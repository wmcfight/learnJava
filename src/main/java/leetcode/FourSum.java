package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int index1 = 0 ,index2,index3,index4;
        if(num.length<=3) return result;
        Arrays.sort(num);
        for(index1 = 0;index1<num.length-3;index1++){
            if(index1 > 0 && num[index1] == num[index1-1]){
                continue;
            }
            for(index2 = index1+1;index2<num.length-2;index2++){
                if(index2 > index1+1 && num[index2] == num[index2-1]){
                    continue;
                }

                index3 = index2+1;
                index4 = num.length-1;
                while(index3 < index4){
                    if(index3 > index2+1 && num[index3] == num[index3-1]){
                        index3++;
                        continue;
                    }
                    if(index4 < num.length-1 && num[index4] == num[index4+1]){
                        index4--;
                        continue;
                    }

                    int sum = num[index1] + num[index2] + num[index3] + num[index4];
                    if(sum == target){
                        ArrayList<Integer> tempArray = new ArrayList<Integer>();
                        tempArray.add(num[index1]);
                        tempArray.add(num[index2]);
                        tempArray.add(num[index3]);
                        tempArray.add(num[index4]);
                        index3++;
                        index4--;
                        result.add(tempArray);
                    }else if(sum < target){
                        index3++;
                    }else{
                        index4--;
                    }
                }
            }
        }

        return result;
    }
}
