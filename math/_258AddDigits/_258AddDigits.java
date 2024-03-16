package math._258AddDigits;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // cách 1:
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    // cách 2: áp dụng tính chất của digits root
//    public int addDigits(int num) {
//        if (num == 0) return 0;
//        return num % 9 == 0 ? 9 : num % 9;
//    }
}

public class _258AddDigits {
    public static void main(String[] args) {
        int num = 38;
        Solution solution = new Solution();
        System.out.println(solution.addDigits(num));
    }
}
