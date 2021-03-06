package leetcode;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

public:
    TreeNode *sortedArrayToBST(vector<int> &num) {
       if(num.size()<=0) return bstSubtree(num,1,0);
       return bstSubtree(num,0,num.size()-1);
    }
private:
    TreeNode* bstSubtree(vector<int>&num,int left,int right){
        if(left > right) return NULL;
        int mid = (left + right) / 2;
        TreeNode *node = new TreeNode(num[mid]);
        node->left = bstSubtree(num,left,mid-1);
        node->right = bstSubtree(num,mid+1,right);
    }
 */
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] data) {
        if (data.length <= 0) return null;
        return buildBST(data, 0, data.length-1);
    }
    private TreeNode buildBST(int[] data, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(data[mid]);
        node.left = buildBST(data, left, mid - 1);
        node.right = buildBST(data, mid + 1, right);
        return node;
    }
}
