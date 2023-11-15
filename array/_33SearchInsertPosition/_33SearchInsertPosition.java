package array._33SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left; // vì phần tử đó vẽ là phần tử đằng sau. (áp dụng binary search).
    }
}

public class _33SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;

        Solution solution = new Solution();

        System.out.println(solution.searchInsert(nums, target));
    }
}
