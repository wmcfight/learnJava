package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.

 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dataSet = new HashSet<Integer>();
        for (int i = 0 ; i < nums.length; i++) {
            if (dataSet.contains(nums[i])) {
                return true;
            } else {
                dataSet.add(nums[i]);
            }
        }
        return false;
    }
}
