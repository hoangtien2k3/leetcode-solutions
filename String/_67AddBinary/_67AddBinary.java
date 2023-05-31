package String._67AddBinary;

class Solution {
    public static String addBinary(String a, String b) {
        while (a.length() < b.length()) a += '0';
        while (a.length() > b.length()) b += '0';

        int carry = 0;
        String ans = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (carry == 1) {
                    ans = '1' + ans;
                    carry = 1;
                } else {
                    ans = '0' + ans;
                    carry = 1;
                }
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (carry == 1) {
                    ans = '1' + ans;
                    carry = 0;
                } else {
                    ans = '0' + ans;
                }
            } else {
                if (carry == 1) {
                    ans = '0' + ans;
                    carry = 1;
                } else {
                    ans = '1' + ans;
                }
            }
        }

        return (carry == 1) ? ('1' + ans) : ans;
    }
}

public class _67AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(Solution.addBinary(a, b));
    }
}
