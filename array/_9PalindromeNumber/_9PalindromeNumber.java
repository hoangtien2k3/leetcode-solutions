package array._9PalindromeNumber;

class Solution {
    public static boolean isPalindrome(int x) {
        // cach 1:
        /* if (x < 0) return false;
         long long temp = x;
         long long check = 0;
         while(temp != 0) {
             int digit = temp % 10;
             check = check * 10 + digit;
             temp /= 10;
         }
         return (check == x);
         */

        // cách 2:
        // String str1 = String.valueOf(x);
        String str1 = Integer.toString(x);

        StringBuilder strCheck = new StringBuilder(str1);
        strCheck.reverse();

        String checkOut = strCheck.toString();

        return checkOut.equalsIgnoreCase(str1);
    }
}

public class _9PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(Solution.isPalindrome(x));
    }
}
