package leetcode;
/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * 注意边界条件就好
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (compare(nums, i, i - 1) && compare(nums, i, i + 1)) {
                result =  i;
                break;
            }
        }
        return result;

    }

    private boolean compare(int[] nums, int cur, int com) {
        if (com < 0 || com > nums.length - 1) return true;
        return nums[cur] > nums[com];
    }
}
