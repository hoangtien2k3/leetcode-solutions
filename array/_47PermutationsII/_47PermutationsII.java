package array._47PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solutionPermutations(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void solutionPermutations(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(new ArrayList<>(current)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            current.add(nums[i]);
            solutionPermutations(nums, result, current, used);

            current.remove(current.size() - 1);
            used[i] = false;

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}

public class _47PermutationsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        for (List<Integer> list : result) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "  ");
            }
            System.out.println();
        }
    }
}
