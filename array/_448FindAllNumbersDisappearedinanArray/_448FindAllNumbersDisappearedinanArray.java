package array._448FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {        // create marker array
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                check.add(i + 1);
            }
        }
        return check;
    }

    /*public static List<Integer> findDisappearedNumbers(int[] nums) {
        BitSet bitSet = new BitSet(nums.length);
        for (int num : nums) {
            bitSet.set(num - 1);
        }

        List<Integer> disappeared = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!bitSet.get(i)) {
                disappeared.add(i + 1);
            }
        }
        return disappeared;
    }*/
}

public class _448FindAllNumbersDisappearedinanArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(Solution.findDisappearedNumbers(nums));
    }
}