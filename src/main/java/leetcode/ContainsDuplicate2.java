package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j
in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.


 */
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0 ) return false;
        Set<Integer> dataSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                dataSet.remove(nums[i-k-1]);
            }
            if (dataSet.contains(nums[i])) {
                return true;
            } else {
                dataSet.add(nums[i]);
            }
        }

        return false;
    }
}
