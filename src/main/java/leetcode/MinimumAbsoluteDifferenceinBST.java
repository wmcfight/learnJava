package leetcode;

/**
 * Given a binary search tree with non-negative values,
 * find the minimum
 * absolute difference between values of any two nodes.
 *
 *
 */

/**
 * 中序遍历
 */
public class MinimumAbsoluteDifferenceinBST {

    private Integer result = Integer.MAX_VALUE;
    private Integer preNumber = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (preNumber != null) {
            result = Math.min(result, Math.abs(preNumber - root.val));
        }
        preNumber = root.val;

        inorder(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        MinimumAbsoluteDifferenceinBST sample = new MinimumAbsoluteDifferenceinBST();
        System.out.println(sample.getMinimumDifference(root));
    }
}
