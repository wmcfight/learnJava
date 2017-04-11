package leetcode;

/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Subscribe to see which companies asked this question.
 bool isSameTree(TreeNode *p, TreeNode *q) {
        while(p!=NULL && q!=NULL){
            if(p->val != q->val){
                return false;
            }
            return isSameTree(p->left,q->left)&&isSameTree(p->right,q->right);
        }
        if(p==NULL) return q==NULL;
        if(q==NULL) return p==NULL;
    }
 */
public class SameTree {
}
