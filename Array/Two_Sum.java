package Array;

class Solution_Two_Sum {
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
}

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        Solution_Two_Sum solution = new Solution_Two_Sum();
        int[] ans = solution.twoSum(nums, target);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}
