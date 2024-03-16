package array._238ProductOfArrayExceptSelf;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // cách 1:
        int n = nums.length;
        int[] result = new int[n];

        int left = 1;
        for(int i = 0; i < n; i++) {
            result[i] = left;
            left = left * nums[i];
        }

        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;



        // cách 2:
//        int n = nums.length;
//        int[] result = new int[n];
//
//        int[] leftProducts = new int[n];
//        int[] rightProducts = new int[n];
//
//        // Tính tích của các phần tử bên trái của mỗi phần tử
//        leftProducts[0] = 1;
//        for (int i = 1; i < n; i++) {
//            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
//        }
//
//        // Tính tích của các phần tử bên phải của mỗi phần tử
//        rightProducts[n - 1] = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
//        }
//
//        // Kết hợp kết quả từ hai mảng tích
//        for (int i = 0; i < n; i++) {
//            result[i] = leftProducts[i] * rightProducts[i];
//        }
//
//        return result;
    }

}

public class _238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
