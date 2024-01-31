package tree._110BalancedBinaryTree;


class TreeNode {
    int val;
    int height;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isBalance(root.left, root.right);
    }

    private boolean isBalance(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        return node1.val == node2.val && isBalance(node1.left, node2.right) && isBalance(node1.right, node2.left);
    }
}

public class _110BalanceBinaryTree {
    public static void main(String[] args) {

    }
}
