package Array._46Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> allList = new ArrayList<>();
        backtracking(nums, list, allList, nums.length);
        return list;
    }

    public static void backtracking(int[] nums, List<List<Integer>> list, List<Integer> allList, int n){
        if (allList.size() == nums.length) {
            list.add(new ArrayList<>(allList));
            return;
        }
        for(int i = 0; i < n; i++) {
            if (!allList.contains(nums[i])) {
                allList.add(nums[i]);
                backtracking(nums, list, allList, n);
                allList.remove(allList.size() - 1);
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
