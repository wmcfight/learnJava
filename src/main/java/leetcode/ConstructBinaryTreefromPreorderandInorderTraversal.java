package leetcode;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        if(preorder.size()<=0 || preorder.size() != inorder.size()) return NULL;
        return bulidNode(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
    }
private:
    TreeNode *bulidNode(vector<int> &preorder, int pleft,int pright,
                        vector<int> &inorder,int ileft, int iright){

        if(pleft > pright) return NULL;
        TreeNode *nNode = new TreeNode(preorder[pleft]);
        int index = findInorder(inorder, ileft,iright, preorder[pleft]);
        int pindex = index - ileft + pleft;
        nNode->left  = bulidNode(preorder,pleft+1,pindex,inorder,ileft,index-1);
        nNode->right = bulidNode(preorder, pindex+1,pright,inorder,index+1,iright);

        return nNode;
    }

    int findInorder(vector<int>&inorder, int ileft, int iright,int data){
        for(int i=ileft;i<=iright;++i){
            if(inorder[i] == data){
                return i;
            }
        }
        return -1;
    }
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
}
