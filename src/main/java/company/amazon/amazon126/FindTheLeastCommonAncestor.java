package company.amazon.amazon126;

import leetcode.SumOfLeftLeaves;

/**
 * LCA
 */
public class FindTheLeastCommonAncestor {
    public SumOfLeftLeaves.TreeNode findLCA(SumOfLeftLeaves.TreeNode root,
                                            SumOfLeftLeaves.TreeNode nodeA,
                                            SumOfLeftLeaves.TreeNode nodeB) {
        if (root == null) return null;
        if (root == nodeA || root == nodeB) return root;
        SumOfLeftLeaves.TreeNode leftLCA = findLCA(root.left, nodeA, nodeB);
        SumOfLeftLeaves.TreeNode rightLCA = findLCA(root.right, nodeA, nodeB);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
