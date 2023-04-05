package Array._39CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void CombiSolve(List<List<Integer>> all_list, List<Integer> list, int[] candidates, int target, int index, int sum) {
        if (sum > target) {
            return; // backtract
        }
        if (sum == target) {
            all_list.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            CombiSolve(all_list, list, candidates, target, i, sum);
            list.remove(Integer.valueOf(candidates[i]));
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all_list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        CombiSolve(all_list, list, candidates, target, 0, 0);
        return all_list;
    }
}

public class _39CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,5};
        int target = 8;

        Solution solution = new Solution();
        List<List<Integer>> all_list = solution.combinationSum(candidates, target);
        System.out.println(all_list);
    }
}
