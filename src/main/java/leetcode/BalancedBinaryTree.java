package leetcode;

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more than 1.


public:
    bool isBalanced(TreeNode *root) {
       int depth = 1;
       return getDepth(root,depth);
    }
private:
    bool getDepth(TreeNode* root,int& depth){
        if(root == NULL) return true;
        int ldepth = 0,rdepth = 0;
        if(root->left != NULL) ldepth++;
        if(root->right != NULL) rdepth++;

        if( getDepth(root->left,ldepth) && getDepth(root->right,rdepth) && abs(ldepth-rdepth)<2) {
            depth += max(ldepth,rdepth);
            return true;
        }
        else return false;
    }

 */
public class BalancedBinaryTree {
    boolean isBalanced(TreeNode data) {
        if (data == null) {
            return true;
        }
        int leftDep = getDepth(data.left);
        int rightDep = getDepth(data.right);
        if (Math.abs(leftDep - rightDep) <= 1) {
            return isBalanced(data.left) && isBalanced(data.right);
        } else {
            return false;
        }
    }

    int getDepth(TreeNode data) {
        if (data == null) return 0;
        if (data.left == null && data.right == null) return 1;
        return Math.max(getDepth(data.left) + 1, getDepth(data.right) + 1);
    }
}
