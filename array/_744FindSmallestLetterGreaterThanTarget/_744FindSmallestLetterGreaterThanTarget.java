package array._744FindSmallestLetterGreaterThanTarget;

import java.util.Arrays;

class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        for (char c : letters) {
            if (c > target) return c;
        }
        return letters[0];
    }
}

public class _744FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(Solution.nextGreatestLetter(letters, target));
    }
}