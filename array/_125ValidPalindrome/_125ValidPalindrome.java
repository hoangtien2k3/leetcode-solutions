package array._125ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        // vì bài này có các ý tự không phải chữ số hay chữ cái. nên ko dùng reverst() được
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Character.isLetterOrDigit(s.charAt(left): kiểm tra ký tự đó có phải chữ cái hay chữ số không, nếu không thì trả về false.
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}

public class _125ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(s));
    }
}
