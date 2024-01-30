package array._58LengthOfLastWord;

import java.util.Arrays;

class Solution {
    public int lengthOfLastWord(String s) {

        // cách 2:
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
        String s = "   fly me   to   the moon  ";
        System.out.println(solution.lengthOfLastWord(s));
    }
}
