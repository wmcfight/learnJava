package leetcode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.

 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class DiameterofBinaryTree {
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int lDep = depth(root.left);
        int rDep = depth(root.right);

        result = Math.max(result, lDep + rDep);
        return 1 + Math.max(lDep, rDep);
    }

}
