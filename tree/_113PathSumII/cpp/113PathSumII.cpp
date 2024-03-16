#include<iostream>
#include<queue>
using namespace std;

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> result;
        vector<int> currentPath;
        dfs(root, targetSum, currentPath, result);
        return result;
    }

private:
    void dfs(TreeNode* node, int targetSum, vector<int>& currentPath, vector<vector<int>>& result) {
        if (!node)
            return;

        currentPath.push_back(node->val);

        if (!node->left && !node->right && targetSum == node->val)
            result.push_back(currentPath);

        dfs(node->left, targetSum - node->val, currentPath, result);
        dfs(node->right, targetSum - node->val, currentPath, result);

        currentPath.pop_back();
    }
};

int main() {
    // TreeNode* root = nullptr;
    // insert(root, 5);
    // insert(root, 4);
    // insert(root, 8);
    // insert(root, 11);
    // insert(root, 7);
    // insert(root, 2);
    // insert(root, 13);
    // insert(root, 4);
    // insert(root, 5);
    // insert(root, 1);

    // Solution solution = new Solution();
    // int targetSum = 22;
    // vector<vector<int>> result = solution.pathSum(root, targetSum);
    // cout << result;
}