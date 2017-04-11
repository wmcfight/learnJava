package leetcode;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space
 (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int cur = m + n - 1, ca = m - 1 , cb = n - 1;
        while(ca >= 0 && cb >= 0) {
            A[cur--] = A[ca] >= B[cb] ? A[ca--] : B[cb--];
        }
        while(cb >= 0) {
            A[cur--] = B[cb--];
        }
    }
}
