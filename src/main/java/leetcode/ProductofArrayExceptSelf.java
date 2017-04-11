package leetcode;

/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity?
 (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int dataLen = nums.length;
        int[] left = new int[dataLen];
        int[] right = new int[dataLen];
        int[] result = new int[dataLen];

        left[0] = 1; right[dataLen-1] = 1;
        for (int i = 1; i < dataLen; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i = dataLen-2;i >=0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i=0; i < dataLen; i++) {
            result[i] = left[i]*right[i];
        }

        return result;
    }
}
