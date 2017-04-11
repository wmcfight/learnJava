package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class Pair{
    int key;
    int value;
    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
    int getKey(){
        return key;
    }

    int getValue(){
        return value;
    }
}

class newCompare implements Comparator {
    public final int compare(Object A, Object B){
        return ((Pair)A).getValue() - ((Pair)B).getValue();
    }
}
public class TwoSum1{
    public int[] twoSum(int[] numbers, int target) {
        List<Pair> datas = new ArrayList<Pair>();
        for(int i=0;i<numbers.length;i++){
            datas.add(new Pair(i+1,numbers[i]));
        }

        Collections.sort(datas,new newCompare());
        int result[] = {0,0};
        int left = 0,right = numbers.length-1;

        while(left<right){
            int lval = datas.get(left).getValue(), rval = datas.get(right).getValue();
            if(lval + rval == target){
                result[0] = datas.get(left).getKey();
                result[1] = datas.get(right).getKey();
                if(result[0] > result[1]){
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                break;
            }else if(lval + rval < target){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }


}