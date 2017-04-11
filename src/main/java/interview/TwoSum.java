package interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TwoSum {
    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.valueOf(br.readLine());
        int size = Integer.valueOf(br.readLine());
        int[] data = new int[size];
        int cur = 0;
        while(cur < size){
            data[cur++] = Integer.valueOf(br.readLine());
        }
        br.close();
        System.out.println(solution(data, target));
    }

    private static int solution(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i+1; j < data.length; j++) {
                if (data[i] + data[j] == target) {
                    return 1;
                }
            }
        }
        return 0;
    }

}
