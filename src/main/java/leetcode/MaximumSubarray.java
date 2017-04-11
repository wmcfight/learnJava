package leetcode;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

int maxSubArray(int A[], int n) {
        int result = INT_MIN, cur = 0;
        for(int i=0;i<n;i++){
            cur = max(A[i],cur+A[i]);
            result = max(result,cur);
        }
        return result == INT_MIN ? 0 : result;
    }
 */
public class MaximumSubarray {
}
