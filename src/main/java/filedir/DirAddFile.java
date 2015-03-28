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

/**
 * Descriptions of the class DirAddFile.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月23日 下午3:22:37
 */

//添加文件
public class DirAddFile {
	private String dirname;
	public DirAddFile(String dirname){
		this.dirname = dirname;
	}
	
	public void addFile(String filename){
		String filepath = dirname + "/"+ filename;
		File file = new File(filepath);
		if(!file.exists()){
			try {
				file.createNewFile();
				System.out.println("Create file "+ filepath + " successfully!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Create file "+ filepath + " unsuccessfully!");
			}
		}else{
			System.out.println( filepath + " existed!");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		DirAddFile dirAddFile = new DirAddFile("./file");
		int i=0;
		while(true){
			dirAddFile.addFile(String.valueOf(i));
			i++;
			Thread.sleep(2000);
		}
	}
}
