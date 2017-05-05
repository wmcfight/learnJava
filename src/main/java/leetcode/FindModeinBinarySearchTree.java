package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 return 2
 */
public class FindModeinBinarySearchTree {
    private Integer maxCount = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {

        Map<Integer,Integer> data = new HashMap<>();
        inorder(root, data);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : data.entrySet()) {
            if (maxCount == entry.getValue()) {
                result.add(entry.getKey());
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root, Map<Integer,Integer> data) {
        if (root == null) return;
        inorder(root.left, data);
        int curCount = data.getOrDefault(root.val, 0) + 1;
        data.put(root.val, curCount);
        maxCount = Math.max(maxCount, curCount);
        inorder(root.right, data);
    }

    public static void main(String[] args) {
        FindModeinBinarySearchTree sample = new FindModeinBinarySearchTree();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(2);

        System.out.println(sample.findMode(node));
    }


}
