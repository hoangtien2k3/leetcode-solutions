package Array._29DivideTwoIntegers;

class Solution {
    public int divide(int dividend, int divisor) {
        long result = 0;

        // không được dùng * / + - nêu ta sẽ dùng XOR(^) để xác định dấu của số bị chia và số chia
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Chuyển cả hai số về dạng long để xử lý trường hợp Integer.MIN_VALUE
        long dividendSum = Math.abs((long) dividend);
        long divisorSum = Math.abs((long) divisor);

        // Lặp qua từng bit của dividend
        while (dividendSum >= divisorSum) {
            long temp = divisorSum;
            long multiple = 1;

            /*
            *  multiple * divisor <= dividend
               temp << 1 -> divisor (dịch sang phải 1 bit) tương đương -> (temp * 2)
            * */
            while (dividendSum >= (temp << 1)) { // temp << 1 -> divisor ()
                temp <<= 1; // gán ngược temp = temp * 2
                multiple <<= 1; // multiple = multiple * 2
            }

            // Trừ multiple * divisor từ dividend
            dividendSum -= temp;
            result += multiple;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // Áp dụng dấu vào kết quả
        return (int) (result * sign);
    }
}

public class _29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int dividend = 10;
        int divisor = 3;
        int result = solution.divide(dividend, divisor);
        System.out.println(result);
    }
}

