package Array._98ValidateBinarySearchTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

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
    public boolean isValidBST(TreeNode root) {
        return checkBinarySearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkBinarySearchTree(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        // check giá trị của node con bên trái phải bé hơn giá trị root
        // đồng thời giá trị của node con bên phải lớn hơn giá trị của root
        // ở đây ta so sánh với giá trị min và giá trị max
        if (root.val > min && root.val < max) {
            // đệ quy sang bên trái
            boolean leftValid = checkBinarySearchTree(root.left, min, root.val);
            // đệ quy sang bên phải
            boolean rightValid = checkBinarySearchTree(root.right, root.val, max);
            return leftValid && rightValid;
        } else {
            return false;
        }
    }
}

public class _98ValidateBinarySearchTree {
    public static void main(String[] args) {
    }
}
