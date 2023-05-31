package String._67AddBinary;

class Solution {
    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        while (a.length() < b.length()) a += '0';
        while (a.length() > b.length()) b += '0';

        int carry = 0;
        String ans = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (carry == 1)
                    ans += '1';
                else {
                    ans += '0';
                    carry = 1;
                }
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (carry == 1) {
                    ans += '1';
                    carry = 0;
                } else {
                    ans += '0';
                }

            } else {
                if (carry == 1) {
                    ans += '0';
                    carry = 1;
                } else {
                    ans += '1';
                }
            }
        }

        if (carry == 1)
            ans += '1';

        return new StringBuilder(ans).reverse().toString();
    }
}

public class _67AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(Solution.addBinary(a, b));
    }
}
