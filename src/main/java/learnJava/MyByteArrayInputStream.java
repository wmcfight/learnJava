/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.io.ByteArrayInputStream;

/**
 * Descriptions of the class MyByteArrayInputStream.java's implementation：TODO described the implementation of class
 * @author wmc 2014年4月8日 下午5:35:03
 */
public class MyByteArrayInputStream {
	private static final byte[] data = {
		5,1,2,3,4,5,6,7,8,9,10
	};
	
	public static void main(String[] args) {
		String temp = new String(data);
		System.out.println("String - bytes "+temp);
		
		byteArrayInputStreamUse();
	}
	
	public static void byteArrayInputStreamUse(){
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		byte[] d1 = new byte[3];
		bais.read(d1, 1, 2);
		System.out.println("String - bytes "+d1);
		for(int i=0;i<2;i++){
			if(bais.available() >= 0){ 
				int tmp = bais.read();
				System.out.println(i+" 0x:"+Integer.toHexString(tmp));
				//System.out.printfln("%d : 0x:s\n",i,Integer.toHexString(tmp));
			}
		}
		
		if(!bais.markSupported()){ 
			System.out.println("Make not supported!");
		}else{ 
			System.out.println("Make supported!!");
		}
		
		bais.mark(2);
		bais.reset();
		
		for(int i=0;i<5;i++){
			if(bais.available() >= 0){ 
				int tmp = bais.read();
				System.out.println(i+" 0x:"+Integer.toHexString(tmp));
				//System.out.printfln("%d : 0x:s\n",i,Integer.toHexString(tmp));
			}
		}
		
		bais.skip(2);
		for(int i=0;i<2;i++){
			if(bais.available() >= 0){ 
				int tmp = bais.read();
				System.out.println(i+" 0x:"+Integer.toHexString(tmp));
				//System.out.printfln("%d : 0x:s\n",i,Integer.toHexString(tmp));
			}
		}
		
		
		
		
	}
}
