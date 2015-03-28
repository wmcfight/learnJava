package learnJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCopyOnWriteCollections {
	CopyOnWriteArrayList<Integer> dataArrayList = new CopyOnWriteArrayList<Integer>();
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> dataArrayList = new CopyOnWriteArrayList<Integer>();
		ArrayList<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		Iterator iter = integers.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
		}
		System.out.println("size is "+integers.size());
		dataArrayList.add(1);
		dataArrayList.add(2);
		dataArrayList.add(3);
		try {
			dataArrayList.remove(3);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		Iterator iterator = dataArrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
