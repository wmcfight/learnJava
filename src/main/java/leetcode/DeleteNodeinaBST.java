package leetcode;

/**
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:

 Search for a node to remove.
 If the node is found, delete the node.

 */

/**
 * http://www.cnblogs.com/binwone/p/6052307.html
 *
 1 首先递归的寻找要删除的节点。

 2.找到要删除的节点后，有下面四种情况：

 该节点左右子树均为空—返回null
 该节点只有左子树为空—返回右子树
 该节点只有右子树为空—返回左子树
 该节点左右子树均不为空—寻找该节点的右子树中的最小节点，
 用最小节点的值替代该节点的值，继续递归地去删除右子树中的那个最小节点。


 */
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                TreeNode minNode = findMinNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private TreeNode findMinNode(TreeNode treeNode) {
        while(treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }
}
