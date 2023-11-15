package array._13RomantoInteger;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int romanToInt(String s) {
        // Khởi tạo Map ánh xạ các ký tự La Mã với giá trị tương ứng
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        int previousSum = 0;

        for(char c : s.toCharArray()) {
            int currentValue = romanMap.get(c);

            if (currentValue > previousSum) {
                sum -= previousSum;
            } else {
                sum += previousSum;
            }

            previousSum = currentValue;
        }

        // Thêm giá trị của ký tự cuối cùng vào kết quả
        sum += previousSum;

        return sum;
    }
}

public class _13RomantoInteger {
    public static void main(String[] args) {
        String romanNumber = "XIII";
        int result = Solution.romanToInt(romanNumber);
        System.out.println(result);  // Output: 13
    }
}