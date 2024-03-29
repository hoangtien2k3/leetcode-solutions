using System;
using System.Collections.Generic;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}

public class Solution {
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        List<IList<int>> result = new List<IList<int>>();
        List<int> currentPath = new List<int>();
        Dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void Dfs(TreeNode node, int targetSum, List<int> currentPath, List<IList<int>> result) {
        if (node == null)
            return;

        currentPath.Add(node.val);

        if (node.left == null && node.right == null && targetSum == node.val)
            result.Add(new List<int>(currentPath));

        Dfs(node.left, targetSum - node.val, currentPath, result);
        Dfs(node.right, targetSum - node.val, currentPath, result);

        currentPath.RemoveAt(currentPath.Count - 1);
    }
}

class Program {
    static void Main() {
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
        IList<IList<int>> paths = solution.PathSum(root, targetSum);

        Console.WriteLine("Root-to-leaf paths with sum " + targetSum + ":");
        foreach (var path in paths) {
            Console.WriteLine(string.Join(" -> ", path));
        }
    }
}