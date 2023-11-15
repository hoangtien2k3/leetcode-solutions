package string;

// cách 1:
/*
class Solution_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        boolean dp[][]=new boolean[s.length()][s.length()];

        int maxLength=0;
        int start = 0;
        int end = 0;

        for(int g = 0; g < s.length(); g++){
            for(int i = 0, j = g; j < s.length(); i++, j++) {
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j]){
                    if(j-i+1 > maxLength){
                        maxLength = j-i+1;
                        start = i;
                        end = j;
                    }
                }

            }
        }

        return s.substring(start, end + 1);
    }
}
*/


// cách 2:
class Solution_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Solution_Longest_Palindromic_Substring solution = new Solution_Longest_Palindromic_Substring();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }
}
