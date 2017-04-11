package leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

/*
Given an array of integers, find out whether there are two distinct indices i and j in the array
such that the absolute difference
between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) return false;
        SortedSet<Long> dataSet = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                dataSet.remove((long)nums[i-k-1]);
            }
            if (dataSet.subSet((long)nums[i]-t,(long)nums[i]+t+1).size() > 0) {
                return true;
            }
            dataSet.add((long)nums[i]);

        }

        return false;
    }
}
