package fileStream;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileInStream implements Runnable {
	private DataInputStream inputStream;
	private int dataPos;
	private int dataCount;
	
	

	public FileInStream(String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}
		dataPos = 0;
		dataCount = 0;
		inputStream = new DataInputStream(new FileInputStream(file));

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				if (inputStream.available() > 1) {
					int size = inputStream.readInt();
					byte[] data = new byte[size];
					//System.out.println("pos is "+dataPos + " size is "+size);
					int count = inputStream.read(data, 0, size);
					dataPos += count;
					System.out.println("Get Result is "+new String(data,"UTF-8"));
				}else{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				inputStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
//		FileInStream handler = new FileInStream("testFileStream");
//		new Thread(handler).start();
		File file = new File("./file/test2");
		DataOutputStream outStream = new DataOutputStream(new FileOutputStream(file));
		outStream.writeLong(10000);
		outStream.flush();
		
		File file1 = new File("./file/test2");
		DataInputStream inputStream = new DataInputStream(new FileInputStream(file1));
		long data = inputStream.readLong();
		System.out.println("Result is "+data);
		
	}

}
