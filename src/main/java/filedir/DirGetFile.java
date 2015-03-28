/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package filedir;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Descriptions of the class DirGetFile.java's implementation：TODO described the
 * implementation of class
 * 
 * @author wmc 2014年4月23日 下午5:22:14
 */
//用java 7 提供的nio 包通过句柄状态变更方式监控文件夹
public class DirGetFile implements Runnable {
	private Path dirname;
	Map<WatchKey, Path> keys = new ConcurrentHashMap<WatchKey, Path>();
	private static WatchService watcher = null;

	public DirGetFile(String dirname) {
		this.dirname = Paths.get(dirname);
		try {
			watcher = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void register(Path dir) throws IOException {
		WatchKey key = dirname.register(watcher,
				java.nio.file.StandardWatchEventKinds.ENTRY_CREATE,
				java.nio.file.StandardWatchEventKinds.ENTRY_DELETE,
				java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY);

		Path ePath = keys.get(key);
		if (ePath == null) {
			System.out.println("Register dir " + dir);
		} else if (!dirname.equals(ePath)) {
			System.out.format("Update from %s -> %s \n", ePath, dir);
		}

		keys.put(key, dirname);

	}

	private void registerChild(File files) throws IOException {
		for (File file : files.listFiles()) {
			if (file.isDirectory()) {
				register(Paths.get(file.getPath()));
				registerChild(file);
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			register(dirname);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (true) {
				WatchKey key = watcher.take();
				Path path = keys.get(key);
				if (path == null) {
					continue;
				}

				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind kind = event.kind();
					if (kind == java.nio.file.StandardWatchEventKinds.OVERFLOW) {
						continue;
					}

					WatchEvent<Path> evt = (WatchEvent<Path>) event;

					Path name = evt.context();
					System.out.format(new SimpleDateFormat(
							"yyyy-MM-dd hh:mm:ss").format(new Date())
							+ " file %s  %s\n", name.toAbsolutePath(), event.kind().name());

				}

				if (!key.reset()) {
					keys.remove(key);
					if (keys.isEmpty()) {
						break;
					}
				} 
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		DirGetFile handler = new DirGetFile("./file");
		new Thread(handler).start();
	}
}
