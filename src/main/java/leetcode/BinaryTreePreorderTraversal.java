package leetcode;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

vector<int> preorderTraversal(TreeNode *root) {
        stack<TreeNode *> sNode;
        vector<int> result;
        sNode.push(root);
        while(!sNode.empty()){
            TreeNode* temp = sNode.top();
            sNode.pop();
            if(temp != NULL){
                result.push_back(temp->val);

                if(temp->right != NULL){
                    sNode.push(temp->right);
                }

                if(temp->left != NULL){
                    sNode.push(temp->left);
                }



            }
        }
        return result;
    }

 */
public class BinaryTreePreorderTraversal {

}
