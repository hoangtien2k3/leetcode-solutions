package Array;

import java.util.HashMap;
import java.util.Map;

class Solution_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, binarySearch(nums, target + 1) - 1};
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length ;
        while(l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > target || nums[m] == target) {
                r = m; // không nên cho r = m - 1 khi mà nums[m] == target
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;

        Solution_Find_First_and_Last_Position_of_Element_in_Sorted_Array solution = new Solution_Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] ans = solution.searchRange(nums, target);
        System.out.println(ans);
    }
}
