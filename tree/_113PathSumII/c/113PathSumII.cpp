#include<stdio.h>
#include<math.h>

typedef struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
} TreeNode;

void dfs(TreeNode* node, int targetSum, int* currentPath, int currentPathSize, int** result, int* resultSize, int* resultCapacity);

int** pathSum(TreeNode* root, int targetSum, int* returnSize, int** returnColumnSizes) {
    int** result = (int**)malloc(sizeof(int*));
    *returnSize = 0;
    *returnColumnSizes = (int*)malloc(sizeof(int));

    if (!root) return result;

    int* currentPath = (int*)malloc(1000 * sizeof(int));
    int resultCapacity = 1;
    int resultSize = 0;

    dfs(root, targetSum, currentPath, 0, &result, &resultSize, &resultCapacity);

    *returnSize = resultSize;
    *returnColumnSizes = (int*)realloc(*returnColumnSizes, resultSize * sizeof(int));

    return result;
}

void dfs(TreeNode* node, int targetSum, int* currentPath, int currentPathSize, int** result, int* resultSize, int* resultCapacity) {
    if (!node) return;

    currentPath[currentPathSize++] = node->val;

    if (!node->left && !node->right && targetSum == node->val) {
        if (*resultSize >= *resultCapacity) {
            *resultCapacity *= 2;
            *result = (int**)realloc(*result, (*resultCapacity) * sizeof(int*));
        }
        int* newPath = (int*)malloc(currentPathSize * sizeof(int));
        memcpy(newPath, currentPath, currentPathSize * sizeof(int));
        (*result)[(*resultSize)++] = newPath;
    }

    dfs(node->left, targetSum - node->val, currentPath, currentPathSize, result, resultSize, resultCapacity);
    dfs(node->right, targetSum - node->val, currentPath, currentPathSize, result, resultSize, resultCapacity);

    currentPathSize--;
}

int main() {
    TreeNode* root = nullptr;
    insert(root, 5);
    insert(root, 4);
    insert(root, 8);
    insert(root, 11);
    insert(root, 7);
    insert(root, 2);
    insert(root, 13);
    insert(root, 4);
    insert(root, 5);
    insert(root, 1);

    Solution solution = new Solution();
    int targetSum = 22;
    vector<vector<int>> result = solution.pathSum(root, targetSum);
    cout << result;
}