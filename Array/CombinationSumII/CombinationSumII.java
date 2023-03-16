package Array.CombinationSumII;

import javax.naming.PartialResultException;
import javax.swing.plaf.SliderUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    void func(int[] nums, List<List<Integer>> arr, int index, int target, List<Integer> temp) {

        // điều kiện dừng của đệ quy.
        if (target == 0) {
            arr.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }

            temp.add(nums[i]);

            func(nums, arr, i+1, target-nums[i], temp);

            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        func(nums, list, 0, target, new ArrayList<>());
        return list;
    }
}

public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = new int[] {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(nums, target));
    }
}
