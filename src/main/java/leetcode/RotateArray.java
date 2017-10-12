package leetcode;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Related problem: Reverse Words in a String II

 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int cur = 0;
        int end = cur + k -1;
        for (cur = 0 ; cur < nums.length ;) {
            end = (end < nums.length ) ? end : nums.length - 1;
            for(int i = cur, j = end; i< j; i++, j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (end < nums.length) {
                cur = end + k + 1;
                end = cur + k - 1;
            }
        }
    }
}
