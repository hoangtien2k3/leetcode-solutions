package string._28FindTheIndexOfTheFirstOccurrenceInAString;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//            if (haystack.substring(i, i + needle.length()).equals(needle)) {
//                return i;
//            }

            if (haystack.startsWith(needle, i)) {
                return i;
            }
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}

public class _28FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(solution.strStr(haystack, needle));
    }
}
