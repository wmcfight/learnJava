package leetcode;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int prev = 0, cur =1;
        for(int i=0;i<n;i++){
            int temp = cur;
            cur = cur+prev;
            prev = temp;
        }

        return cur;
    }
}
