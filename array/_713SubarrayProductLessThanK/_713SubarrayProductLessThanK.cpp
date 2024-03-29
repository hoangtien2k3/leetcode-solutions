//
// Created by Hoàng Anh Tiến on 30/03/2024.
//

#include<iostream>
#include<cmath>
#include<vector>
using namespace std;

class Solution_713 {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        if (k <= 1) return 0;

        int preIndex = 1;
        int i = 0, j = 0, result = 0;

        while(i < nums.size()) {
            preIndex = preIndex * nums[i];
            while(preIndex >= k) {
                preIndex /= nums[j++];
            }

            result = result + (i - j) + 1;
            i++;
        }

        return result;
    }
};

int main() {
    vector<int> nums = {10, 5, 2, 6};
    int k = 100;
    Solution_713 solution;
    int result = solution.numSubarrayProductLessThanK(nums, k);
    cout << result;
    return 0;
}