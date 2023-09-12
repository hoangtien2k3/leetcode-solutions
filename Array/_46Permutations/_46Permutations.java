package Array._46Permutations;

import java.util.ArrayList;
import java.util.List;

/*
#
#                              []
#                           /   |   \
#                       /       |       \
#                    /          |           \
#                 [1]          [2]            [3]
#               /     \       /   \           /  \
#            [1,2]  [1,3]  [2,1]   [2,3]    [3,1] [3,2]
#              |      |      |       |        |     |
#           [1,2,3][1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
#
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

public class _46Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.permute(nums));
    }
}
