#include<iostream>
#include<cmath>
#include<string>
#include<vector>

class Solution {
public:
    void Conditions(vector<vector<int>>& all_vec, vector<int>& vec, vector<int>& candidates, int target, int currSum, int index) {
        if (currSum > target) {
            return; // backtracking
        }
        if (currSum == target) {
            all_vec.push_back(vec);
            return;
        }
        for(int i = index; i < candidates.size(); i++) {
            vec.push_back(candidates[i]);
            currSum += candidates[i];
            Conditions(all_vec, vec, candidates, target, currSum, i);
            vec.pop_back();
            currSum -= candidates[i];
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> all_vec;
        vector<int> vec;
        Conditions(all_vec, vec, candidates, target, 0, 0);
        return all_vec;
    }
};

int main() {
    vector<int> candidates = {2,3,6,7};
    vector<vector<int>> all_vec;
    vector<int> vec;
    Solution solution;
    solution.combinationSum(candidates, target);
    return all_vec;
}