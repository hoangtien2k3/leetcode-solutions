package tree._112PathSum;

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
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkLeftAndRight(root, 0, targetSum);
    }

    private boolean checkLeftAndRight(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }

        sum += root.val; // tinh tổng qua mỗi node và cộng dồn chúng lại với nhau.
        // khi mã cả node con bên trái và node con bên phải cùng troẻ đến null -> node cuối cùng của danh sách
        // khi đó là node cuối cùng, nên ta chỉ cần kiểm tra sum == targetSum và trả về.
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        // tiếp tục đệ quy sang bên trái cây.
        boolean left = checkLeftAndRight(root.left, sum, targetSum);
        // tiếp tục đệ quy sang bên phải của cây.
        boolean right = checkLeftAndRight(root.right, sum, targetSum);

        return left || right; // nếu hoặc cây bên trái hoac cây bên phaải bằng targetSum trả về true.
    }

}

public class _112PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        Solution solution = new Solution();
        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println(result);
    }
}
