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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height_balanced(root) != -1;
    }

    public int height_balanced(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height_balanced(root.left);
        int rightHight = height_balanced(root.right);
        if (leftHeight == -1 || rightHight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;
        return Math.max(leftHeight, rightHight) + 1;
    }
}

public class _110BalanceBinaryTree {
    public static void main(String[] args) {

    }
}
