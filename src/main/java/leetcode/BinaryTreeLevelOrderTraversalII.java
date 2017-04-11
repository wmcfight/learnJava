package leetcode;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
public:
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        if(inorder.size() <=0 || inorder.size() != postorder.size()) return NULL;
        return buildNode(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1);
    }
private:
    TreeNode* buildNode(vector<int> &inorder, int ileft, int iright,
                        vector<int> &postorder,int pleft,int pright){
        if(pleft > pright) return NULL;
        TreeNode *node = new TreeNode(postorder[pright]);
        int index = findInorder(inorder,ileft,iright,postorder[pright]);
        int pindex = pright - (iright - index);
        node->left = buildNode(inorder,ileft,index-1,postorder,pleft,pindex-1);
        node->right = buildNode(inorder,index+1,iright,postorder,pindex,pright-1);

        return node;
    }

    int findInorder(vector<int>&inorder,int ileft,int iright, int target){
        for(int i = ileft; i<=iright; ++i){
            if(inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
 */
public class BinaryTreeLevelOrderTraversalII {
}
