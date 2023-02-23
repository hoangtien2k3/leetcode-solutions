package Array._3SumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int curSum = nums[i] + nums[left] + nums[right];
                if(curSum == target) return target;
                if(curSum > target) right--;
                if(curSum < target) left++;
                if(Math.abs(curSum - target) < Math.abs(result - target))
                    result = curSum;
            }
        }

        return result;
    }
}

public class Three_Sum_Closest {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,2,1,-4};
        int target = 1;
        Solution solution = new Solution();
        int ans = solution.threeSumClosest(nums, target);
        System.out.println(ans);
    }
}
