package learnJava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


class Pair {
	int key;
	int value;

	Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	int getKey() {
		return key;
	}

	int getValue() {
		return value;
	}
}

class newCompare implements Comparator {
	public final int compare(Object A, Object B) {
		return ((Pair) A).getValue() - ((Pair) B).getValue();
	}
}

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		List<Pair> datas = new ArrayList<Pair>();
		for (int i = 0; i < numbers.length; i++) {
			datas.add(new Pair(i + 1, numbers[i]));
		}
		ArrayList<ArrayList<Integer>> dataArrayList = new ArrayList<ArrayList<Integer>>();

		Collections.sort(datas, new newCompare());
		int result[] = { 0, 0 };
		int left = 0, right = numbers.length - 1;

		while (left < right) {
			int lval = datas.get(left).getValue(), rval = datas.get(right)
					.getValue();
			if (lval + rval == target) {
				result[0] = datas.get(left).getKey();
				result[1] = datas.get(right).getKey();
				if (result[0] > result[1]) {
					int temp = result[0];
					result[0] = result[1];
					result[1] = temp;
				}
				break;
			} else if (lval + rval < target) {
				left++;
			} else {
				right--;
			}
		}

		return result;
	}

	public int threeSumClosest(int[] num, int target) {

		if (num.length <= 2)
			return 0;
		int index1 = 0, index2, index3;
		Arrays.sort(num);
		int cursum = num[index1] + num[index1 + 1] + num[index1 + 2];
		for (index1 = 0; index1 < num.length - 2; index1++) {
			if (index1 > 0 && num[index1] == num[index1 - 1]) {
				continue;
			}

			index2 = index1 + 1;
			index3 = num.length - 1;

			while (index2 < index3) {
				if (index2 > index1 + 1 && num[index2] == num[index2 - 1]) {
					index2++;
					continue;
				}

				if (index3 < num.length - 1 && num[index3] == num[index3 + 1]) {
					index3--;
					continue;
				}

				int sum = num[index1] + num[index2] + num[index3];
				if (sum == target)
					return sum;
				cursum = (Math.abs(sum - target) <= Math.abs(cursum - target)) ? sum
						: cursum;

				if (sum < target) {
					index2++;
				} else {
					index3--;
				}
			}
		}

		return cursum;
	}

	public void nextPermutation(int[] num) {
		if (num.length <= 1)
			return;
		int i, j = 0, k;
		boolean find = false;
		for (i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				j = i + 1;
				find = true;
				break;
			}
		}

		if (!find) {
			reverse(num, 0, num.length - 1);
		} else {
			for (k = num.length - 1; k >= 0; k--) {
				if (num[i] < num[k]) {
					break;
				}
			}
			int temp = num[i];
			num[i] = num[k];
			num[k] = temp;
			reverse(num, j, num.length - 1);
		}

	}

	public void reverse(int[] num, int left, int right) {
		while (left < right) {
			int temp = num[left];
			num[left] = num[right];
			num[right] = temp;
			left++;
			right--;
		}
	}

	public int trap(int[] A) {
		if (A.length <= 1)
			return 0;
		int sum = 0, cur = 0;
		int i = 0, j = A.length - 1, direction = 0;
		while (i < j)
			if (direction == 0) {
				cur = A[i] <= A[j] ? A[i] : A[j];
				direction = A[i] <= A[j] ? 1 : -1;
			} else if (direction > 0) {
				if (cur >= A[++i]) {
					sum += cur - A[i];
				} else {
					direction = 0;
				}
			} else {
				if (cur >= A[--j]) {
					sum += cur - A[j];
				} else {
					direction = 0;
				}
			}
		return sum;
	}

	private void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1;i>=0;i--){
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = digits[i]/10;
            if(carry == 0){
                break;
            }
        }
        
        if(carry != 0){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        }else{
            return digits;
        }
    }
	

	public ArrayList<Integer> grayCode(int n) {
        ArrayList<String> curS = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n<=0) {
            result.add(0);
        }else{
            curS.add("0");curS.add("1");
            int cur = 1;
            while(cur<=n){
            	 ArrayList<String> prevS = new ArrayList<String>();
            	for(int i=0;i<2;i++){
            		if( i == 1) Collections.reverse(curS);
            		for(String item: curS){
            			StringBuffer sBuffer = new StringBuffer(item).reverse();
            			sBuffer.append(i);
                        prevS.add(sBuffer.reverse().toString());
                    }
            	}
            	curS.clear();
            	curS = prevS;
            	cur++; 
            }
            
            for(String item:curS){
            	result.add(convertStoInt(item));
            }
            
            for(int it:result){
            	System.out.println(it);
            }
        }
        
        
        return result;
    }
	
	private int convertStoInt(String data){
		int result = 0;
		for(int i=0;i<data.length();i++){
			result = result*2 + data.charAt(i) - '0';
		}
		return result;
	}
	
	public static void main(String[] args) {
		int data[] = { 9 };
		List<String> result = new LinkedList<String>();
		Solution handlerSolution = new Solution();
		handlerSolution.grayCode(2);
		// System.out.println("Result is "+result);
		// for(int item:result){
		// System.out.println(item);
		// }
	}
}