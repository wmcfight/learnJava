package leetcode;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 * 特别类似SearchInRotatedSortedArray
 * 一定要注意控制数组的输出，
 * 因为 mid = (begin + end) / 2,导致可能会省略，所以一定得是begin ＝ mid + 1
 * 测试case
 * {5,1,2,3,4}
 * {3,4,5,1,2}
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length-1;
        int result = nums[begin];
        result = Math.min(result, nums[end]);
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[begin] <= nums[end]) {
                if (nums[begin] <= nums[mid]) {
                    result = Math.min(result, nums[begin]);
                    end = mid;
                } else {
                    result = Math.min(result, nums[mid]);
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] >= nums[end]) {
                    result = Math.min(result, nums[end]);
                    begin = mid + 1;
                } else {
                    result = Math.min(result, nums[mid]);
                    end = mid;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        FindMinimuminRotatedSortedArray sample = new FindMinimuminRotatedSortedArray();
        System.out.println(sample.findMin(nums));
    }
}
