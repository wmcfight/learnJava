package leetcode;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int minN = nums[0], maxN = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp1 = nums[i] * minN;
            int temp2 = nums[i] * maxN;

            minN = Math.min(temp1, Math.min(temp2, nums[i]));
            maxN = Math.max(temp1, Math.max(temp2, nums[i]));

            result = Math.max(result, maxN);
        }
        return result;
    }
}
