package leetcode;

public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        int left = 0 , right = A.length - 1, mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (A[mid] == target) return mid;
            else {
                if (A[left] < A[mid] ) {
                    if (A[left] <= target && target < A[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                } else if (A[left] == A[mid]) {
                    left++;
                } else if (A[mid] < A[right]) {
                    if (A[mid] < target && target <= A[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
        }
        return -1;
    }
}
