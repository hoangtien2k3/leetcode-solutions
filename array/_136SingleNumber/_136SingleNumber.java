package array._136SingleNumber;

import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        // cách 1:
//        for(int i = 0; i < nums.length; i++) {
//            int c = 0;
//            for(int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    c++;
//                }
//            }
//            if (c == 1) {
//                return nums[i];
//            }
//        }
//        return 0;

        // cách 2
        return Arrays.stream(nums)
                .filter(num -> Arrays
                        .stream(nums)
                        .filter(n -> n == num)
                        .count() == 1
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No unique number found"));

    }
}

public class _136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1};
        System.out.println(solution.singleNumber(nums));
    }
}
