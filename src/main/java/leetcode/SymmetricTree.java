package leetcode;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

public:
    bool isSymmetric(TreeNode *root) {
        TreeNode *p=root,*q=root;
        return symmetricHelper(p,q);
    }
private:
    bool symmetricHelper(TreeNode* p,TreeNode*q){
        if(p == NULL && q==NULL) return true;
        else if(p!=NULL && q!=NULL){
            if(p->val == q->val){
                return symmetricHelper(p->left,q->right)&&symmetricHelper(p->right,q->left);
            }else{
                return false;
            }

        }else{
            return false;
        }
    }

 */
public class SymmetricTree {
}
