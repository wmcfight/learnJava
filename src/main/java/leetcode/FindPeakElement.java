package leetcode;

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
