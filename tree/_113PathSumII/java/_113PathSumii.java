package tree._113PathSumII.java;

import java.util.ArrayList;
import java.util.List;

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

    TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            print(root.left);
            print(root.right);
        }
    }

}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null)
            return;

        currentPath.add(node.val);

        if (node.left == null && node.right == null && targetSum == node.val)
            result.add(new ArrayList<>(currentPath));

        dfs(node.left, targetSum - node.val, currentPath, result); // đệ quy
        dfs(node.right, targetSum - node.val, currentPath, result); // ddeej

        currentPath.removeLast(); // quay lui
    }
}

public class _113PathSumii {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        Solution solution = new Solution();
        List<List<Integer>> paths = solution.pathSum(root, targetSum);
        System.out.println(paths);
    }
}
