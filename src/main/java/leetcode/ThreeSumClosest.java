package leetcode;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if(num.length<=2) return 0;
        int index1 = 0, index2,index3;
        Arrays.sort(num);
        int cursum = num[index1] + num[index1+1] + num[index1+2];
        for(index1 = 0;index1<num.length-2;index1++){
            if(index1 > 0 && num[index1] == num[index1-1]){
                continue;
            }

            index2 = index1 + 1;
            index3 = num.length-1;

            while(index2 < index3){
                if(index2>index1+1 && num[index2] == num[index2-1]){
                    index2++;
                    continue;
                }

                if(index3<num.length-1 && num[index3] == num[index3+1]){
                    index3--;
                    continue;
                }

                int sum = num[index1] + num[index2] + num[index3];
                if(sum == target) return sum;
                cursum = (Math.abs(sum - target) <= Math.abs(cursum - target)) ? sum : cursum;

                if(sum<target){
                    index2++;
                }else{
                    index3--;
                }
            }
        }

        return cursum;
    }
}
