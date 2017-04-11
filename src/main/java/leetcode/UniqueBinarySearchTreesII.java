package leetcode;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
public:
    vector<TreeNode *> generateTrees(int n) {
        if(n<=0) return generateSubTrees(1,0);
        return generateSubTrees(1,n);
    }

private:
    vector<TreeNode *> generateSubTrees(int begin, int end){
        vector<TreeNode *> subTree;
        if(begin > end){
            subTree.push_back(NULL);
        }

        for(int start = begin; start<=end;start++){
            vector<TreeNode*> leftSubTree = generateSubTrees(begin,start-1);
            vector<TreeNode*> rightSubTree = generateSubTrees(start+1,end);
            for(int i=0;i!=leftSubTree.size();++i){
                for(int j=0;j!=rightSubTree.size();++j){
                    TreeNode *node = new TreeNode(start);
                    node->left = leftSubTree[i];
                    node->right = rightSubTree[j];
                    subTree.push_back(node);
                }
            }
        }

        return subTree;
    }
 */
public class UniqueBinarySearchTreesII {
}
