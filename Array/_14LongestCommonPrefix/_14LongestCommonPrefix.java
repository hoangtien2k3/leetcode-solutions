package Array._14LongestCommonPrefix;

import java.util.Arrays;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return stringBuilder.toString();
            } else {
                stringBuilder.append(str1.charAt(i));
            }
        }

        String result = stringBuilder.toString();

        return result.isEmpty() ? "" : stringBuilder.toString();
    }
}

public class _14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(Solution.longestCommonPrefix(strs));
    }
}
