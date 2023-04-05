package Array._41FirstMissingPositive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// cách 1:
//class Solution {
//    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        // 3,4,-1,1
//
//        // bước 1: Đánh dấu tất cả các số âm và các số lớn hơn n (độ dài của mảng) là không liên quan đến kết quả.
//        for (int i = 0; i < n; i++) {
//            if (nums[i] <= 0 || nums[i] > n) {
//                nums[i] = n + 1; // đánh dấu là n + 1
//            }
//        }
//
//        // bước 2: Sử dụng các chỉ mục mảng như một phương thức băm để đánh dấu sự hiện diện của các số dương trong mảng.
//        // Các phần tử trong mảng sẽ được đánh dấu là số âm để biểu thị rằng chúng đã xuất hiện trong mảng.
//        for (int i = 0; i < n; i++) {
//            int idx = Math.abs(nums[i]);
//            if (idx <= n) {
//                nums[idx-1] = -Math.abs(nums[idx-1]);
//            }
//        }
//
//        // bước 3: Tìm số dương còn thiếu đầu tiên
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > 0) {
//                return i+1;
//            }
//        }
//
//        // bước 4: Xử lý trường hợp có mặt tất cả các số dương từ 1 đến n
//        return n+1;
//    }
//}



// cách 2:
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        for(int i = 1; i < nums.length; i++) {
            if (!numbers.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}


public class _41FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, -1, 1};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }
}
