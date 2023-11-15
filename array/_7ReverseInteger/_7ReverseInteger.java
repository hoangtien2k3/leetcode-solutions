package array._7ReverseInteger;

class Solution {
    public static int reverse(int x) {
        String xx = Integer.toString(x);
        String check = null;
        if (x < 0) {
            check = xx.substring(1);
        } else {
            check = xx;
        }

        StringBuilder stringBuilder = new StringBuilder(check);
        stringBuilder.reverse();

        if (x < 0) stringBuilder.insert(0, '-');

        long value = Long.parseLong(stringBuilder.toString());
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) return 0;

        return (int) value;
    }
}

public class _7ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(Solution.reverse(x));
    }
}
