package learnJava;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class learnTransientTest {
	private static File file = null;

	public static void serialization() {
		file = new File("test.txt");
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		learnTransient sample = new learnTransient(10, "12134");
		learnTransient sample1 = new learnTransient(2, "2323");
		try {
			FileOutputStream fOutputStream = new FileOutputStream(file);

			ObjectOutputStream outputStream = new ObjectOutputStream(
					new FileOutputStream(file));
			outputStream.writeObject(sample);
			outputStream.writeObject(sample1);
			fOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}

		file = null;

	};

	public static void deserialization() {
		file = new File("test.txt");
		if (!file.exists()) {
			System.out.println("the file doesnot exist!");
			return;
		}

		ObjectInputStream oinInputStream;
		try {
			oinInputStream = new ObjectInputStream(new FileInputStream(file));
			learnTransient sample;
			try {
				while ( true) {
					sample = (learnTransient) oinInputStream.readObject();
					System.out.println("age is " + sample.getAge());
					System.out.println("pwd is " + sample.getPwd());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException e) {
				System.out.println("finally finish!");
			}finally{
				oinInputStream.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		learnTransientTest.serialization();
		learnTransientTest.deserialization();
	}

}
