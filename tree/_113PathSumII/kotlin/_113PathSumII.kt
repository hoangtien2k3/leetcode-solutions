package tree._113PathSumII.kotlin

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun print(root: TreeNode?) {
        if (root != null) {
            print(root.`val`.toString() + " ")
            print(root.left)
            print(root.right)
        }
    }
}

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        val currentPath = ArrayList<Int>()
        dfs(root, targetSum, currentPath, result)
        return result
    }

    private fun dfs(node: TreeNode?, targetSum: Int, currentPath: ArrayList<Int>, result: ArrayList<ArrayList<Int>>) {
        if (node == null)
            return

        currentPath.add(node.`val`)

        if (node.left == null && node.right == null && targetSum == node.`val`)
            result.add(ArrayList(currentPath))

        dfs(node.left, targetSum - node.`val`, currentPath, result)
        dfs(node.right, targetSum - node.`val`, currentPath, result)

        currentPath.removeAt(currentPath.size - 1)
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left?.left = TreeNode(11)
    root.left?.left?.left = TreeNode(7)
    root.left?.left?.right = TreeNode(2)
    root.right?.left = TreeNode(13)
    root.right?.right = TreeNode(4)
    root.right?.right?.left = TreeNode(5)
    root.right?.right?.right = TreeNode(1)

    val solution: Solution = Solution()
    val targetSum: Int = 22;
    val result: List<List<Int>> = solution.pathSum(root, targetSum)
    println(result)
}