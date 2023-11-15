package tree._98ValidateBinarySearchTree;

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

        if (root.val > min && root.val < max) {
            boolean leftValid = checkBinarySearchTree(root.left, min, root.val);
            boolean rightValid = checkBinarySearchTree(root.right, root.val, max);
            return leftValid && rightValid;
        } else {
            return false;
        }
    }
}

public class _98ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode invalidBST = new TreeNode(5);
        invalidBST.left = new TreeNode(1);
        invalidBST.right = new TreeNode(8);
        invalidBST.right.left = new TreeNode(4);
        invalidBST.right.right = new TreeNode(10);

        TreeNode validBST = new TreeNode(5);
        validBST.left = new TreeNode(3);
        validBST.right = new TreeNode(7);
        validBST.left.left = new TreeNode(1);
        validBST.left.right = new TreeNode(4);
        validBST.right.left = new TreeNode(6);
        validBST.right.right = new TreeNode(9);

        Solution solution = new Solution();
        System.out.println("Is invalidBST a valid BST: " + solution.isValidBST(invalidBST)); // false
        System.out.println("Is validBST a valid BST: " + solution.isValidBST(validBST));     // true
    }
}
