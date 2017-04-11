package leetcode;

public class MinimumAbsoluteDifferenceinBST {

    private Integer result = Integer.MAX_VALUE;
    private Integer preNumber = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        middleLoop(root);
        return result;
    }

    private void middleLoop(TreeNode root) {
        if (root == null) return;
        middleLoop(root.left);
        if (preNumber != null) {
            result = Math.min(result, Math.abs(preNumber - root.val));
        }
        preNumber = root.val;

        middleLoop(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        MinimumAbsoluteDifferenceinBST sample = new MinimumAbsoluteDifferenceinBST();
        System.out.println(sample.getMinimumDifference(root));
    }
}
