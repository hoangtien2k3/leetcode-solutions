package Array.MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int max_Sum_Subarray = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            max_Sum_Subarray = Math.max(max_Sum_Subarray, currSum);
        }
        return max_Sum_Subarray;
    }
}

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
