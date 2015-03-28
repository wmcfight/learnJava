import java.util.Arrays;

public class Interview2 {
	public static Integer[] top100 (Integer[] data) {
		Integer[] result = new Integer[100];
		for(int i = 0; i<100; i++) {
			result[i] = data[i];
		}
		Arrays.sort(result);
		for(int i=100; i < data.length; i++) {
			Integer cur = data[i];
			if(cur > result[0]) {
				int curi = 0;
				int curj = 0;
				while(2*curi + 1 < 100) {
					curj = 2*curi + 1;
					if(curj < 100 - 1 && result[curj] > result[curj+1]) {
						curj++;
					}
					if(result[curj] < cur) {
						result[curi] = result[curj];
						curi = curj;
					} else {
						break;
					} 
				}
				result[curi] = cur;
			}
		}
		Arrays.sort(result);
		return result;
	}

	public static void main(String[] args) {
		Integer[] data = new Integer[10000000];
		for(int i=0; i<10000000; i++) {
			data[i] = i+1;
		}
				
		Integer[] result = Interview2.top100(data);
		for (Integer item : result) {
			System.out.print(item+" ");
		}
	}

}
