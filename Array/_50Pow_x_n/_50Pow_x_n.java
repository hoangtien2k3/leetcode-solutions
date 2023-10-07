package Array._50Pow_x_n;

class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double result = 1.0;
        long absN = Math.abs((long) n); // Handle integer overflow for n = Integer.MIN_VALUE
        while (absN > 0) {
            if (absN % 2 == 1) {
                result *= x;
            }
            x *= x;
            absN /= 2;
        }

        return n < 0 ? 1 / result : result;
    }
}

public class _50Pow_x_n {
    public static void main(String[] args) {
        double x = 4;
        int n = 3;
        System.out.println(Solution.myPow(x, n));
    }
}
