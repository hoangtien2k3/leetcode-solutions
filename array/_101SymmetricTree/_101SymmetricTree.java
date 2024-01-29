package array._101SymmetricTree;

class TreeNode {
    int val;
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
        if (root == null) return true;
        return isCheckTreeNode(root.left, root.right);
    }

    private boolean isCheckTreeNode(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.val == tree2.val
                && isCheckTreeNode(tree1.left, tree2.right)
                && isCheckTreeNode(tree1.right, tree2.left);
    }
}

public class _101SymmetricTree {
    public static void main(String[] args) {
    }
}
