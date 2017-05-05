package leetcode;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int> > result;
        if(root == NULL) return result;
        vector<int> cpath;
        path(root,sum,result, cpath);
        cpath.clear();
        return result;
    }
private:
    void path(TreeNode *root,int sum,vector<vector<int> >&result, vector<int>&depPath){
        if(root == NULL) return;
        depPath.push_back(root->val);
        sum -= root->val;
        if(root->left == NULL && root->right == NULL){
            if(sum == 0) result.push_back(depPath);
        }
        path(root->left,sum,result,depPath);
        path(root->right,sum,result,depPath);
        depPath.pop_back();

    }

 */


import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        dfs(root, sum, new LinkedList<Integer>(), result);
        return result;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> curPath, List<List<Integer>> result) {
        if (root == null) return;
        curPath.addLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if(sum == 0) {
                // pay attention
                result.add(new LinkedList<>(curPath));
            }
        }
        dfs(root.left, sum, curPath, result);
        dfs(root.right, sum, curPath, result);
        curPath.removeLast();
    }

}
