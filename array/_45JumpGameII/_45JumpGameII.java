package array._45JumpGameII;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1;
        int jump_Index = 0, l = 0, r = 0;

        while (r < n) {
            int check = 0;
            for (int i = l; i <= r; i++) {
                check = Math.max(check, nums[i] + i);
            }
            l = r + 1;
            r = check;
            ++jump_Index;
        }

        return jump_Index;
    }
}

public class _45JumpGameII {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.jump(nums));
    }
}
