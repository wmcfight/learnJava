package leetcode;

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        int result[] = {-1, -1};
        if (A == null || A.length <= 0) return result;
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        findTarget(A, result, target, 0, A.length - 1);
        result[0] = (result[0] == Integer.MAX_VALUE) ? -1 : result[0];
        result[1] = (result[1] == Integer.MIN_VALUE) ? -1 : result[1];
        return result;
    }

    private void findTarget(int[] A, int[] result, int target, int left, int right) {
        if (left > right) return;
        int mid = (left + right) / 2;
        if (A[mid] < target) {
            findTarget(A, result, target, mid + 1, right);
        } else if (A[mid] > target) {
            findTarget(A, result, target, left, mid - 1);
        } else {
            result[0] = Math.min(result[0], mid);
            result[1] = Math.max(result[1], mid);
            findTarget(A, result, target, mid + 1, right);
            findTarget(A, result, target, left, mid - 1);
        }

    }
}
