package leetcode;

/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

 vector<int> postorderTraversal(TreeNode *root) {
        stack<TreeNode* > sNode;
        vector<int> result;
        if(root == NULL) return result;
        TreeNode *temp = root;
        TreeNode *cmp = NULL;
        bool visited = false;
        while(!sNode.empty() || temp!=NULL){
            if(temp != NULL){
                sNode.push(temp);
                temp = temp->left;
            }else{
                temp = sNode.top();
                if(temp->right != NULL && temp->right != cmp){
                    temp = temp->right;
                }else{
                    result.push_back(temp->val);
                    sNode.pop();
                    cmp = temp;
                    temp = NULL;
                }
            }
        }

        return result;
    }

 */
public class BinaryTreePostorderTraversal {
}
