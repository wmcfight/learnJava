package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
/**
 * 用map 搞
 */
public class IntersectionOfTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> numMap = new HashMap<>();
        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            numMap.put(nums1[i], numMap.getOrDefault(nums1[i], 0) + 1);
        }
        int totalSize = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (numMap.getOrDefault(nums2[i], 0) > 0) {
                resultMap.put(nums2[i], numMap.getOrDefault(nums2[i], 0) + 1);
                numMap.put(nums2[i], numMap.getOrDefault(nums2[i], 0) - 1);
                totalSize++;
            }
        }

        int[] result = new int[totalSize];
        int cur = 0;
        for (Map.Entry item : resultMap.entrySet()) {
            for (int i = 0; i < (int)item.getValue(); i++) {
                result[cur++] = (int)item.getKey();
            }

        }
        return result;
    }
}
