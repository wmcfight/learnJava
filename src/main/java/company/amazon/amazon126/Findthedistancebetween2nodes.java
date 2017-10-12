package company.amazon.amazon126;

/**
 * Given a Binary Search Tree, Find the distance between 2 nodes
 *
 * 1  Least common ancestor.
 */

import leetcode.SumOfLeftLeaves;
import lombok.Synchronized;

/**
 *
 */
public class Findthedistancebetween2nodes {
    public static int Distance(SumOfLeftLeaves.TreeNode root,
                               SumOfLeftLeaves.TreeNode node1, SumOfLeftLeaves.TreeNode node2)
    {
        SumOfLeftLeaves.TreeNode node = findLeastCommonAncestor(root, node1, node2);
        int distLCA = findLevel(root, node);
        int dist1 = findLevel(root, node1);
        int dist2 = findLevel(root, node2);

        return dist1 + dist2 - 2 * distLCA;
    }

    private static SumOfLeftLeaves.TreeNode findLeastCommonAncestor(SumOfLeftLeaves.TreeNode root,
                                                                    SumOfLeftLeaves.TreeNode node1,
                                                                    SumOfLeftLeaves.TreeNode node2)
    {
        if (root == null) return null;
        //找到两个节点中的一个就返回
        if (root.val == node1.val || root.val== node2.val)
            return root;
        //分别在左右子树查找两个节点

        SumOfLeftLeaves.TreeNode left_lca = findLeastCommonAncestor(root.left, node1, node2);
        SumOfLeftLeaves.TreeNode right_lca = findLeastCommonAncestor(root.right, node1, node2);

        if (left_lca != null && right_lca != null)
            //此时说明，两个节点肯定是分别在左右子树中，当前节点比为LCA
            return root;
        return left_lca != null ? left_lca : right_lca;
    }

    private static int findLevel(SumOfLeftLeaves.TreeNode root, SumOfLeftLeaves.TreeNode node)
    {

        if (root == null)
            return -1;
        if(root.val == node.val)
            return 0;

        int level = findLevel(root.left, node);

        if (level == -1)
            level = findLevel(root.right, node);

        if(level != -1)
            return level + 1;

        return -1;
    }
}
