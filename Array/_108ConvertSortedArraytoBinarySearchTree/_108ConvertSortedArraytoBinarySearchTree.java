package Array._108ConvertSortedArraytoBinarySearchTree;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode result = insertRoot(nums, 0, nums.length - 1);
        return result;
    }

    public TreeNode insertRoot(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = insertRoot(nums, left, mid - 1);
        root.right = insertRoot(nums, mid + 1, right);

        return root;
    }
}

public class _108ConvertSortedArraytoBinarySearchTree {
    // duyet cay
    public static void Print_Tree(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            Print_Tree(treeNode.left);
            Print_Tree(treeNode.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        Solution solution = new Solution();
        TreeNode result = solution.sortedArrayToBST(nums);
        Print_Tree(result);
    }
}
