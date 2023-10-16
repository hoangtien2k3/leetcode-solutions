package Array._989AddtoArray_FormofInteger;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        StringBuilder num2Builder = new StringBuilder(num2);
        while (num1.length() > num2Builder.length()) num2Builder.insert(0, "0");
        num2 = num2Builder.toString();
        StringBuilder num1Builder = new StringBuilder(num1);
        while (num1Builder.length() < num2.length()) num1Builder.insert(0, "0");
        num1 = num1Builder.toString();

        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int temp = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
            carry = temp / 10;
            res.insert(0, (char) (temp % 10 + '0'));
        }
        if (carry > 0) res.insert(0, "1");

        return res.toString();
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        // đổi mảng int sang String bằng cách dùng StringBulilder
        StringBuilder sb = new StringBuilder();
        for (Integer digit : num) {
            sb.append(digit);
        }
        String strNumbers = sb.toString();

        // đổi int sang String
        String kStr = Integer.toString(k);

        // cộng hai String với nhau và trả về String kết quả
        String result = addStrings(strNumbers, kStr);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < result.length(); i++) {
            // int numDigit = Character.getNumericValue(result.charAt(i));
            int numDigit = (result.charAt(i) - '0');
            list.add(numDigit);
        }

        return list;
    }
}

public class _989AddtoArray_FormofInteger {
    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0};
        int k = 34;
        System.out.println(Solution.addToArrayForm(num, k));
    }
}