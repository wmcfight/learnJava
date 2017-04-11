package leetcode;

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

void recoverTree(TreeNode *root) {
        vector<TreeNode*> con;
        inOrder(root,con);
        if(con.size()<=1) return;
        TreeNode *prev = NULL,*tail = NULL;
                for(int i=0;i<con.size()-1;++i){
        if(con[i]->val > con[i+1]->val){
        prev = con[i];
        break;
        }
        }

        for(int i=con.size()-1;i>0;--i){
        if(con[i]->val < con[i-1]->val){
        tail = con[i];
        break;
        }
        }

        swap(prev->val,tail->val);

        }

private:
        void inOrder(TreeNode* root,vector<TreeNode*>& data){
        if(root == NULL) return;
        inOrder(root->left,data);
        data.push_back(root);
        inOrder(root->right,data);
        }


 */
public class RecoverBinarySearchTree {
}
