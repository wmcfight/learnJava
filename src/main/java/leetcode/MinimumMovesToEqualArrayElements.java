package leetcode;

/*
Given a non-empty integer array of size n,
find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
/**
 * http://blog.csdn.net/yeqiuzs/article/details/53078666
 * 这个题目很巧妙
 *
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        long result = 0;
        if (nums.length <= 1) return (int)result;
        int minN = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            minN = Math.min(minN, nums[i]);
        }
        return (int)( result - nums.length * minN);
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements sample = new MinimumMovesToEqualArrayElements();
        int[] data = {83,86,77,15,93,35,86,92,49,21};
        System.out.println(sample.minMoves(data));
    }
}
