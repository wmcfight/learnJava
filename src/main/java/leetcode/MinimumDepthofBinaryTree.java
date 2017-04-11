package leetcode;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

int minDepth(TreeNode *root) {
       if(root == NULL) return 0;
       int cdepth = 0;
       stack<pair<TreeNode *,int> > sData;
       sData.push(make_pair(root,1));
       int result = INT_MAX;
       while(!sData.empty()){

           TreeNode *cur = sData.top().first;
           cdepth = sData.top().second;
           sData.pop();
           if(cur->left == NULL && cur->right == NULL){
               result = min(result,cdepth);
           }
           if(cur->left  && result > cdepth){
               sData.push(make_pair(cur->left,cdepth+1));
           }
           if(cur->right && result > cdepth){
               sData.push(make_pair(cur->right,cdepth+1));
           }
       }

       return result;
    }

 */
public class MinimumDepthofBinaryTree {
}
