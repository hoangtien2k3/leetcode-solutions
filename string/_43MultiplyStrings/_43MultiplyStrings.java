package string._43MultiplyStrings;

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


    // cách 2:
    public String mul(String a, String b) {
        String res = "";
        int m = a.length();
        int n = b.length();
        int len = m + n - 1;

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int carry = 0;
        for(int i = 0; i < len; i++) {
            int temp = 0;
            for(int j = 0; j < m; j++) {
                // i - j < n : kiểm tra xem vị trí hiện tại trong vòng lặp thứ j có năm trong phạm vi của chuỗi b hay không.
                // i - j >= 0 : để chỉ mục index không bao giờ được nhỏ hay vượt quá.
                if (i - j < n && i - j >= 0) {
                    temp += (a.charAt(j) - '0') * (b.charAt(i - j) - '0');
                }
            }
            temp += carry;
            carry = temp/10;
            res = (char)(temp % 10 + '0') + res;
        }

        while(carry > 0) {
            res = (char)(carry % 10 + '0') + res;
            carry /= 10;
        }

        // loai bo phan so 0 thu
        StringBuilder sb = new StringBuilder(res);
        while(res.length() > 0 && res.charAt(0) == '0') {
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
