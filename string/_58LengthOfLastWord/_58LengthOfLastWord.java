package string._58LengthOfLastWord;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int lengthOfLastWord(String s) {
        // cách 1
//        int length = 0;
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            char c = s.charAt(i);
//
//            if (c == ' ' && length == 0) {
//                continue;
//            }
//
//            if (c != ' ') {
//                length++;
//            } else {
//                break;
//            }
//        }
//
//        return length;


        // cách 2
        return Arrays.stream(s.split(" "))
                .filter(word -> !word.isEmpty())
                .reduce((first, second) -> second)
                .map(String::length)
                .orElse(0);
    }
}

public class _58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
