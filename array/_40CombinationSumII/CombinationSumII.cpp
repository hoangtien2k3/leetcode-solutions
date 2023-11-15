
#include<iostream>
#include<cmath>
#include<string>
#include<vector>

class Solution {
public:
    void search(vector<vector<int>>& vec, vector<int>& lv, vector<int>& candidates, int target, int start) {
        if (target == 0) {
            vec.push_back(lv);
            return;
        }
        for(int i = start; i < candidates.size(); i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            lv.push_back(candidates[i]);
            search(vec, lv, candidates, target-candidates[i], i+1);

            // loai bo cac tham so khong thoa man trong vector<int>
            // lv.size() - 1 : có nghĩa là(số lượng phần tử trong vector<int> sẽ bị loại bỏ đi 1 phần từ, đê xét tiếp các phần tử thoải mã điều kiện cần thêm vào so sánh với target cần )
            lv.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> vec;
        vector<int> lv;
        search(vec, lv, candidates, target, 0);
        return vec;
    }
};


int main() {
    System("cls");
    vector<int> vec = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    Solution solution;
    cout << solution.combinationSum2(vec, target);

    return 0;
}
