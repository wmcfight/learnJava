package leetcode;

/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes
from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

public:
    int maxPathSum(TreeNode *root) {
        if(root == NULL) return 0;
        int maxPS = INT_MIN;
        getPathSum(root,maxPS);
        return maxPS;
    }
private:
    int getPathSum(TreeNode* root,int& sum){
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL){
            sum = max(sum,root->val);
            return root->val;
        }
        int ldep = getPathSum(root->left,sum),rdep = getPathSum(root->right,sum);
        int cMax = root->val + max(0,ldep) + max(0,rdep);
        sum = max(sum,cMax);
        int mdep = max(ldep,rdep);
        return root->val + max(mdep,0);
    }
 */
public class BinaryTreeMaximumPathSum {
    private int maxPath = Integer.MIN_VALUE;
    int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPath;
    }

    int maxPath(TreeNode root) {
        if(root == null) return 0;
        int leftMax = maxPath(root.left);
        int rightMax = maxPath(root.right);
        maxPath = Math.max(maxPath, root.val + Math.max(0, leftMax) + Math.max(0, rightMax));
        return root.val + Math.max(0, Math.max(leftMax, rightMax));
    }
}
