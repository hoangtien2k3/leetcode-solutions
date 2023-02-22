package Array;

import java.util.ArrayList;
import java.util.List;

class Solution_Search_in_Rotated_Sorted_Array {
    // Binary Search O(log n)
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] == target)
                return m;
            if (nums[m] >= nums[l]) {
                if (nums[m] >= target && nums[l] <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] <= target && nums[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}


public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Solution_Search_in_Rotated_Sorted_Array solution = new Solution_Search_in_Rotated_Sorted_Array();

        int target = 3;
        int[] nums = new int[] {4,5,6,7,0,1,2};

        System.out.println(solution.search(nums, 3));

    }
}
