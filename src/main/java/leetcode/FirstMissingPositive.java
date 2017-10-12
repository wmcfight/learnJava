package leetcode;

/**
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for (int i = 0;i < A.length; i++) {
            int cur = i;
            while ((cur >= 0 && cur < A.length) && A[cur] != cur + 1) {
                if (A[cur] >= 1 && A[cur] <= A.length && A[A[cur] - 1] != A[cur]) {
                    int temp = A[A[cur] - 1];
                    A[A[cur] - 1] = A[cur];
                    A[cur] = temp;
                } else {
                    break;
                }
            }
        }

        for (int i=0 ; i< A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
