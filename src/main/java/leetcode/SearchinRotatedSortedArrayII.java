package leetcode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

Subscribe to see which companies asked this question.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int left = 0 , right = A.length - 1, mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (A[mid] == target) return true;
            else {
                if (A[left] < A[mid] ) {
                    if (A[left] <= target && target < A[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                } else if (A[left] == A[mid]) {
                    left++;
                } else if (A[left] > A[mid]) {
                    if (A[mid] < target && target <= A[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
        }
        return false;
    }
}
