package string._415AddStrings;

class Solution {
    public static String addStrings(String num1, String num2) {
        String res = "";

        StringBuilder num2Builder = new StringBuilder(num2);
        while(num1.length() > num2Builder.length())
            num2Builder.insert(0, "0");
        num2 = num2Builder.toString();
        StringBuilder num1Builder = new StringBuilder(num1);
        while(num1Builder.length() < num2.length())
            num1Builder.insert(0, "0");
        num1 = num1Builder.toString();

        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; i--) {
            int temp = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
            carry = temp / 10;
            res = (char)(temp % 10 + '0') + res;
        }

        if (carry > 0)
            res = "1" + res;

        return res;
    }
}

public class _415AddStrings {
    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(Solution.addStrings(num1, num2));
    }
}