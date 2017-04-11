package leetcode;

/*
Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {

    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for(int item : A){
            two |= one & item;
            one ^= item;
            three = ~(one & two);

            one &= three;
            two &= three;
        }

        return one;
    }
}
