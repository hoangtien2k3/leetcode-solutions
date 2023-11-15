package tree._100SameTree;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;

        if (p.val == q.val) {
            boolean checkTree1 = isSameTree(p.left, q.left);
            boolean checkTree2 = isSameTree(p.right, q.right);
            return checkTree1 && checkTree2;
        }

        return false;
    }
}

public class _100SameTree {
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
        System.out.println(solution.isSameTree(invalidBST, validBST));
    }
}
