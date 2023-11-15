package array._33SearchInRotatedSortedArray;

class Solution {

    // áp dụng thuật toán tìm kiếm nhị phân với độ phức tạp của thuật toán là O(log n)
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + ((r - l) >> 1);
            // điều kiện dừng của thuật toán.
            if (nums[m] == target)
                return m;

            // để kiểm tra xem, nếu mảng có 1 phần tử hoặc giá trị của phần tử trước lớn hơn phần tử sau thì xét tiếp.
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

public class _33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;

        Solution solution = new Solution();

        System.out.println(solution.search(nums, target));
    }
}
