package leetcode;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Subscribe to see which companies asked this question.


public:
    int sumNumbers(TreeNode *root) {
        if(root == NULL) return 0;
        return getSum(root,0);

    }

private:
    int getSum(TreeNode* root,int sum){
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL){
            return sum * 10 + root->val;
        }else{
            int lsum = getSum(root->left,sum * 10 + root->val), rsum = getSum(root->right,sum * 10 + root->val);
            return lsum + rsum;
        }
    }

    int getNewNumber(int begin, int end){
        int weight = 1, cur= end;
        while(cur > 0){
            weight*=10;
            cur/=10;
        }
        weight/=10;
        return end == 0 ? 0 : begin*weight + end;
    }
 */
public class SumRoottoLeafNumbers {
}
