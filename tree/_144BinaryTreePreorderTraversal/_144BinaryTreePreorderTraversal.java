package tree._144BinaryTreePreorderTraversal;

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
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorder(new ArrayList<>(), root);
    }

    public List<Integer> preorder(List<Integer> list, TreeNode root) {
        if (root == null)
            return list;
        list.add(root.val);
        list = preorder(list, root.left);
        list = preorder(list, root.right);
        return list;
    }
}

public class _144BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }
}
