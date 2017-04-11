package leetcode;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A.length <= 1)
            return 0;
        int sum = 0, cur = 0;
        int i = 0, j = A.length - 1, direction = 0;
        while (i < j)
            if (direction == 0) {
                cur = A[i] <= A[j] ? A[i] : A[j];
                direction = A[i] <= A[j] ? 1 : -1;
            } else if (direction > 0) {
                if (cur >= A[++i]) {
                    sum += cur - A[i];
                } else {
                    direction = 0;
                }
            } else {
                if (cur >= A[--j]) {
                    sum += cur - A[j];
                } else {
                    direction = 0;
                }
            }
        return sum;
    }
}
