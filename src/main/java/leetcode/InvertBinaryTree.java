package leetcode;

/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
 */

class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            invert(node.left);
            invert(node.right);
        }

    }
}
