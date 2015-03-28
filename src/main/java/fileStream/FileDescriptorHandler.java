/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package fileStream;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Descriptions of the class FileDescriptorHandler.java's implementation：TODO described the implementation of class
 * @author wmc 2014年5月9日 下午8:15:45
 */
public class FileDescriptorHandler {
	
	
	public static void main(String[] args) {
		FileOutputStream outputStream = new FileOutputStream(FileDescriptor.out);
		
		try {
			outputStream.write(new String("test").getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
