package leetcode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.
 */

/**
  解题思路：
    注意边界条件和中间变量
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                if (temp >= nums.length) {
                    result = i;
                    break;
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return result < 0 ? nums.length : result;
    }

    public static void main(String[] args) {
        MissingNumber sample = new MissingNumber();
        System.out.println(sample.missingNumber(new int[]{1,0,3}));
    }
}
