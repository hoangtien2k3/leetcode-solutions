package Array._4MedianofTwoSortedArrays;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> arrlist = new ArrayList<>();
        for (int j : nums1) arrlist.add(j);
        for (int j : nums2) arrlist.add(j);
        arrlist.sort(Integer::compareTo);
        int n = arrlist.size();
        return (n % 2 == 0)
                ? (double) (arrlist.get((n / 2) - 1) + arrlist.get(n / 2)) / 2
                : (double) (arrlist.get(n / 2));
    }
}

public class _4MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
