package array._713SubarrayProductLessThanK;

/*
* Given an array of integers nums and an integer k, return the number of contiguous subarrays
* where the product of all the elements in the subarray is strictly less than k.
* */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int preIndex = 1;
        int i = 0, j = 0, result = 0;

        while(i < nums.length) {
            preIndex = preIndex * nums[i];
            while(preIndex >= k) {
                preIndex = preIndex / nums[j++];
            }

            result = result + (i - j) + 1;
            i++;
        }

        return result;
    }
}


public class _713SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int result = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(result);
    }
}
