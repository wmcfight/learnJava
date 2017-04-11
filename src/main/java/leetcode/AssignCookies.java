package leetcode;


import java.util.Arrays;

/*
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive.
You cannot assign more than one cookie to one child.
 */
/**
 * 理解题意，NND，不是动态规划，注意搽除就好
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length <= 0 || s.length <= 0) return 0;
        int sum = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = g.length - 1; i >= 0; i--) {
            for (int j = s.length - 1; j >= 0; j--) {
                if (g[i] <= s[j]) {
                    sum++;
                    s[j] = 0;
                    break;
                }
            }
        }
        return sum;
    }
}
