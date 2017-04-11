package leetcode;

/*
vector<int> inorderTraversal(TreeNode *root) {
        stack<TreeNode* >sNode;
        vector<int> result;
        if(root == NULL) return result;
        TreeNode* temp = root;
        while(!sNode.empty() || temp != NULL){
            if(temp != NULL){
                sNode.push(temp);
                temp = temp->left;
            }else{
                temp = sNode.top();
                sNode.pop();
                result.push_back(temp->val);
                temp = temp->right;
            }
        }

        return result;
    }

 */
public class BinaryTreeInorderTraversal {
}
