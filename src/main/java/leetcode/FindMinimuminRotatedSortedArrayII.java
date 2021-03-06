package leetcode;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.


 * 解题思路：
 * 一定去除being == end 的情况
 * 其他的照旧
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        int result = Math.min(nums[begin], nums[end]);
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[begin] < nums[end]) {
                if (nums[begin] <= nums[mid]) {
                    result = Math.min(result, nums[begin]);
                    begin++;
                } else {
                    result = Math.min(result, nums[mid]);
                    end = mid;
                }
            } else if (nums[begin] > nums[end]) {
                if (nums[mid] <= nums[end]) {
                    result = Math.min(result, nums[mid]);
                    end = mid;
                } else {
                    result = Math.min(result, nums[end]);
                    begin = mid + 1;
                }
            } else {
                result = Math.min(result, nums[begin]);
                begin++;
            }
        }
        return result;
    }
}
