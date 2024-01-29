package tree._101SymmetricTree;

class TreeNode {
    int val;
    int height;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.height = 1;
    }

    int height(TreeNode node) {
        return (node == null) ? 0 : node.height;
    }

    int balanceFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    void updateHeight() {
        height = 1 + Math.max(height(left), height(right));
    }

    TreeNode rotateRight() {
        TreeNode newRoot = left;
        left = newRoot.right;
        newRoot.right = this;
        updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    TreeNode rotateLeft() {
        TreeNode newRoot = right;
        right = newRoot.left;
        newRoot.left = this;
        updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    TreeNode insert(int value) {
        if (value < this.val) {
            left = (left == null) ? new TreeNode(value) : left.insert(value);
        } else if (value > this.val) {
            right = (right == null) ? new TreeNode(value) : right.insert(value);
        }

        updateHeight();

        int balance = balanceFactor(this);

        // Left Heavy
        if (balance > 1) {
            // Right Rotation
            if (value < left.val) {
                return rotateRight();
            }
            // Left-Right Rotation
            else {
                left = left.rotateLeft();
                return rotateRight();
            }
        }

        // Right Heavy
        if (balance < -1) {
            // Left Rotation
            if (value > right.val) {
                return rotateLeft();
            }
            // Right-Left Rotation
            else {
                right = right.rotateRight();
                return rotateLeft();
            }
        }

        return this;
    }

    void traverse() {
        if (left != null) left.traverse();
        System.out.print(val + " ");
        if (right != null) right.traverse();
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
}

public class _101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.insert(2);
        treeNode.insert(2);
        treeNode.insert(3);
        treeNode.insert(4);
        treeNode.insert(4);
        treeNode.insert(3);

        treeNode.traverse();

    }
}
