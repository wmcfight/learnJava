package leetcode;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
        public void moveZeroes(int[] nums) {
            if (nums.length <= 0) return;
            int begin = 0, cur = 0;
            while (cur < nums.length) {
                if (nums[cur] != 0) {
                    nums[begin++] = nums[cur];
                }
                cur++;
            }

            while (begin < nums.length) {
                nums[begin] = 0;;
                begin++;
            }

        }
}
