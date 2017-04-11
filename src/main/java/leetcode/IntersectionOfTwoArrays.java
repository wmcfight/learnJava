package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
 */
/**
 * 注意Set<Integer> 和int[] 的转换关系
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            numSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (numSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] result = new int[resultSet.size()];
        int cur = 0;
        for (Integer item : resultSet) {
            result[cur++] = item;
        }
        return result;
    }
}
