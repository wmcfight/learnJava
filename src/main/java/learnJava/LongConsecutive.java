package learnJava;

import java.util.HashSet;
import java.util.Set;


public class LongConsecutive {
	public int longestConsecutive(int[] num) {
        Set<Integer> dataSet = new HashSet<Integer>();
        for (Integer integer : num) {
			dataSet.add(integer);
		}
        int result = 0;
        for (Integer itInteger:num) {
			if (dataSet.contains(itInteger)) {
				int count = 0;
				count++;
				dataSet.remove(itInteger);
				int number = 1;
				while (dataSet.contains(itInteger+number)) {
					count++;
					dataSet.remove(itInteger+number);
					number++;
				}
				number = 1;
				while (dataSet.contains(itInteger-number)) {
					count++;
					dataSet.remove(itInteger-number);
					number++;
				}
				result = Math.max(result, count);
				
			}
		}
		return result;
    }
	
	//public static void main(int )
//	public static void main(String[] args) {
//		int data[] = {1,2,3,4,500,21,10};
//		LongConsecutive handler = new LongConsecutive();
//		
//	    System.out.println("Result is "+handler.longestConsecutive(data));
//	}
}


