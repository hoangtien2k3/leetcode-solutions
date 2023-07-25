package Array._1TwoSum;

/*class Solution_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] returnAns = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    returnAns[0] = i;
                    returnAns[1] = j;
                }
            }
        }
        return returnAns;
    }
}*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

public class _1TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] ans = solution.twoSum(nums, target);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}