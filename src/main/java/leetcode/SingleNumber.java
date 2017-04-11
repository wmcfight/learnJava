package leetcode;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Subscribe to see which companies asked this question.

Show Tags
Show Similar Problems

 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        int result = 0;
        for(int item : A){
            result = result ^ item;
        }
        return result;
    }
}
