package array._704BinarySearch;

import java.util.Arrays;

class Solution {
    public int BinarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        return BinarySearch(nums, target, 0, nums.length - 1);
    }
}

public class _704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(solution.search(nums, target));
    }
}