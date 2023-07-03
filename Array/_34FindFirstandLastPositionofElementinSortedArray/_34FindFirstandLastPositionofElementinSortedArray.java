package Array._34FindFirstandLastPositionofElementinSortedArray;

import java.util.*;

class Solution {

    // cách 1:
//    public int[] searchRange(int[] nums, int target) {
//        int start = binarySearch(nums, target);
//        if (start == nums.length || nums[start] != target) {
//            return new int[]{-1, -1};
//        }
//        return new int[]{start, binarySearch(nums, target + 1) - 1};
//    }
//
//    public int binarySearch(int[] nums, int target) {
//        int l = 0, r = nums.length ;
//        while(l < r) {
//            int m = l + ((r - l) >> 1);
//            if (nums[m] > target || nums[m] == target) {
//                r = m; // không nên cho r = m - 1 khi mà nums[m] == target
//            } else {
//                l = m + 1;
//            }
//        }
//        return l;
//    }




    // cach 2:
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }

    public int findStartingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] >= target) { // tìm phần tử ở phần lớn hơn target
                end = mid-1;
            } else {
                start = mid+1;
            }
            if (nums[mid] == target)
                index = mid;
        }

        return index;
    }

    public int findEndingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] <= target) { // search phần tử phần nhỏ hơn tảtget
                start = mid+1;
            } else {
                end = mid-1;
            }
            if (nums[mid] == target) index = mid;
        }

        return index;
    }
}

public class _34FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        Solution solution = new Solution();
        int[] ans = solution.searchRange(nums, target);

        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(ans[0], ans[1]);
        System.out.println(list);
    }
}
