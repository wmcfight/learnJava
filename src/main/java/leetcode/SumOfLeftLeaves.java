package leetcode;

/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
/**
 * 注意看清楚题意
 */
public class SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int sumOfLeftLeaves(TreeNode root) {
        return addSumLeft(root, false);
    }

    private int addSumLeft(TreeNode root, boolean isLeft) {
        int result = 0;
        if (root != null) {
            if (isLeft) {
                if (root.left == null && root.right == null) {
                    return root.val;
                }
            }
            result += addSumLeft(root.left, true) + addSumLeft(root.right, false);
        }
        return result;
    }




}
