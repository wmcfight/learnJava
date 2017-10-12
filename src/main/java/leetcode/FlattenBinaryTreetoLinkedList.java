package leetcode;

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


 void flatten(TreeNode *root) {
        if(root == NULL) return;
        flatten(root->left);
        TreeNode* realR = root->right;
        root->right = root->left;
        root->left = NULL;
        TreeNode* cur = root;
        while(cur->right){
            cur = cur->right;
        }
        cur->right = realR;
        flatten(realR);
    }
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode realR = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = realR;
        flatten(realR);
    }
}
