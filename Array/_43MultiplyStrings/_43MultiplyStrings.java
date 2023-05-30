package Array._43MultiplyStrings;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // cách 1
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        // Đảo ngược các số để bắt đầu từ vị trí hàng đơn vị
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // Nhân từng chữ số của hai số
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        // Xử lý các chữ số trên mỗi vị trí
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1 + n2; i++) {
            int digit = result[i] % 10;
            int carry = result[i] / 10;
            sb.insert(0, digit);

            if (i < n1 + n2 - 1) {
                result[i + 1] += carry; // Cộng phần nhớ vào vị trí tiếp theo
            }
        }

        // Loại bỏ các chữ số 0 thừa ở đầu
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }


    public String mul(String a, String b) {
        String res = "";
        int n = a.length();
        int m = b.length();
        int len = n + m - 1;

        // Đảo ngược chuỗi đầu vào
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int carry = 0; // biến nhớ
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (i - j < m && i - j >= 0) {  // kiểm tra xem vị trí hiện tại trong vòng lặp có thuộc phạm vi của chuỗi b hay không.
                    int a1 = a.charAt(j) - '0';
                    int b1 = b.charAt(i - j) - '0';
                    tmp += a1 * b1;
                }
            }
            tmp += carry;
            carry = tmp / 10;
            res = (char) (tmp % 10 + '0') + res;
        }

        // Kiểm tra và xử lý trường hợp carry còn dư
        while (carry > 0) {
            res = (char) (carry % 10 + '0') + res;
            carry /= 10;
        }


        // Loại bỏ các chữ số 0 thừa ở đầu
        StringBuilder sb = new StringBuilder(res);
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

}

public class _43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String num1 = "123", num2 = "456";

        System.out.println(solution.multiply(num1, num2));
        System.out.println(solution.mul(num1, num2));

    }
}
