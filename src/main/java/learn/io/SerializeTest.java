/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learn.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Descriptions of the class SerializeTest.java's implementation：TODO described
 * the implementation of class
 * 
 * @author wmc 2014年5月9日 下午3:20:23
 */
public class SerializeTest {
	private static final String filename = ".serializeTest";

	private static void testRead() {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
					new FileInputStream(filename));
			BoxE box = (BoxE) inputStream.readObject();
			System.out.println("Get box info is " + box.toString());
			inputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void testWrite() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new FileOutputStream(filename));

			BoxE box = new BoxE("test", 10, 100);
			System.out.println("Write box info is " + box.toString());
			outputStream.writeObject(box);

			box = new BoxE("root", 2, 3);
			outputStream.flush();
			outputStream.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		testWrite();
		testRead();
	}

}

class Box implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int weight;
	private transient int length;
	private String name;

	public Box(String name, int weight, int length) {
		this.name = name;
		this.weight = weight;
		this.length = length;
	}

	public String toString() {
		return "[name:" + name + "](weight:" + weight + ",length:" + length
				+ ")";
	}

	// to serialize and deserialize static and transient variable
	private void readObject(ObjectInputStream in)
			throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		weight = in.readInt();
		length = in.readInt();
		System.out.println("Box---readObject width=" + weight + ", height="
				+ length);
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeInt(weight);
		out.writeInt(length);
		System.out.println("Box---writeObject width=" + weight + ", height="
				+ length);
	}
}

class BoxE implements Externalizable {
	private String name;
	private static int weight;
	private transient int length;

	public BoxE() {
	}

	public BoxE(String name, int weight, int length) {
		this.name = name;
		this.weight = weight;
		this.length = length;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name);
		out.writeInt(weight);
		out.writeInt(length);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub

		name = (String) in.readObject();
		weight = in.readInt();
		length = in.readInt();

	}

	public String toString() {
		return "[name:" + name + "](weight:" + weight + ",length:" + length
				+ ")";
	}

}
