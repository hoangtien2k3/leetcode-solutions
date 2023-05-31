package Array._66PlusOne;

class Solution {
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // nếu điều kiện tất cả các số đều bằng 9
        int[] newDigits = new int[digits.length + 1];
        newDigits[0]++;
        return newDigits;
    }
}

public class _66PlusOne {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Solution.plusOne(nums));
    }
}
