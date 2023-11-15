package array._53MaximumSubarray;

class Solution {
    public static int maxSubArray(int[] nums) {
        int max_Sum_Subarray = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            max_Sum_Subarray = Math.max(max_Sum_Subarray, currSum);
        }
        return max_Sum_Subarray;
    }
}

public class _53MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Solution.maxSubArray(nums));
    }
}
