package array._128LongestConsecutiveSequence;

import java.util.Arrays;

class Solution {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int count = 1;
        int checkCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    count++;
                } else {
                    checkCount = Math.max(checkCount, count);
                    count = 1;
                }
            }
        }
        return Math.max(count, checkCount);
    }
}

public class _128LongestConsecutiveSequence {
    public static void main(String[] args) {
        // 0 0 1 2 3 4 5 6 7 8
        int[] nums = {100,4,200,1,3,2};
        System.out.println(Solution.longestConsecutive(nums));
    }
}