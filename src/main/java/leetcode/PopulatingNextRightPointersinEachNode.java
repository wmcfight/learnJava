package leetcode;

/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
Subscribe to see which companies asked this question.


 void connect(TreeLinkNode *root) {
        queue<TreeLinkNode*> prev,cur;
        if(root == NULL) return;
        prev.push(root);
        while(!prev.empty()){
            while(!prev.empty()){
                TreeLinkNode *temp = prev.front();
                prev.pop();
                if(prev.empty()){
                    temp->next = NULL;
                }else{
                    temp->next = prev.front();
                }

                if(temp->left != NULL) cur.push(temp->left);
                if(temp->right != NULL) cur.push(temp->right);
            }
            swap(cur,prev);
        }
    }
 */
public class PopulatingNextRightPointersinEachNode {
}
