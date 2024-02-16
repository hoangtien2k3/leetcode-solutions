package array._169MajorityElement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {

        // C1: Boyer-Moore Voting -> [2,2,1,1,1,2,2] -> 1, 1, 1, 2, 2, 2, 2

//        int count = 0;
//        int majortityCount = nums[0];
//
//        for(int i : nums) {
//            if (count == 0)
//                majortityCount = i;
//
//            count += (i == majortityCount) ? 1 : -1;
//        }
//
//        return majortityCount;


        // C2: dùng mảng sắp xếp:
//        Arrays.sort(nums);
//        return nums[nums.length/2];

        // C3: Map


        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int majorityValue = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > count) {
                majorityValue = entry.getKey();
                count = entry.getValue();
            }
        }

        return majorityValue;
    }
}

public class _169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {3, 2, 3};
        System.out.println(solution.majorityElement(nums));
    }
}
