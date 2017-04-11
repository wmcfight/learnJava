package leetcode;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        queue<TreeNode *>cur,prev;
        vector<vector<int> > result;
        if(root == NULL) return result;
        bool direct = true;
        prev.push(root);
        while(!prev.empty()){
            vector<int> vtemp;
            while(!prev.empty()){

                TreeNode *temp = prev.front();
                vtemp.push_back(temp->val);

                if(temp->left != NULL) cur.push(temp->left);
                if(temp->right != NULL) cur.push(temp->right);



                prev.pop();
            }
            if(!direct){
                reverse(vtemp.begin(),vtemp.end());
            }
            direct = !direct;
            result.push_back(vtemp);
            swap(prev,cur);
        }

        return result;
    }

 */
public class BinaryTreeZigzagLevelOrderTraversal {
}
