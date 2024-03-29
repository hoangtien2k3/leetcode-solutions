class TreeNode {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    pathSum(root, targetSum) {
        const result = [];
        const currentPath = [];
        this.dfs(root, targetSum, currentPath, result);
        return result;
    }

    dfs(node, targetSum, currentPath, result) {
        if (!node) return;

        currentPath.push(node.val);

        if (!node.left && !node.right && targetSum === node.val)
            result.push([...currentPath]);

        this.dfs(node.left, targetSum - node.val, currentPath, result);
        this.dfs(node.right, targetSum - node.val, currentPath, result);

        currentPath.pop();
    }
}

// Example usage:
// Construct the binary tree
const root = new TreeNode(5);
root.left = new TreeNode(4);
root.right = new TreeNode(8);
root.left.left = new TreeNode(11);
root.left.left.left = new TreeNode(7);
root.left.left.right = new TreeNode(2);
root.right.left = new TreeNode(13);
root.right.right = new TreeNode(4);
root.right.right.left = new TreeNode(5);
root.right.right.right = new TreeNode(1);

const targetSum = 22;
const solution = new Solution();
const paths = solution.pathSum(root, targetSum);

// Print paths
console.log(`Root-to-leaf paths with sum ${targetSum}:`);
paths.forEach(path => {
    console.log(path.join(" -> "));
});
