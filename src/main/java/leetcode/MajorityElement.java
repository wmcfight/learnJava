package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.

 * ⌊ n/2 ⌋ 表示 n/2 + 1
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2 + 1;
        Map<Integer, Integer> dataMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dataMap.put(nums[i], dataMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry entry : dataMap.entrySet()) {
            if ((Integer) entry.getValue() >= half) {
                result = (int) entry.getKey();
            }
        }

        return result;
    }
}
