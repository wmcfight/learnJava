package leetcode;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

public:
    bool isValidBST(TreeNode *root) {
        int left = INT_MIN,right=INT_MAX;
        return validBST(root,left,right);
    }

private:
    bool validBST(TreeNode *root, int left, int right){
       if(root == NULL) return true;

       return root->val>left
           && root->val<right
           && validBST(root->left,left,root->val)
           && validBST(root->right,root->val,right);
    }
 */
public class ValidateBinarySearchTree {
}
