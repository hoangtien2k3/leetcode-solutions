package string._844BackspaceStringCompare;

import java.util.Objects;

class Solution {
    private String f(String s) {
        StringBuilder t = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == '#') {
                if (!t.isEmpty()) {
                    t.deleteCharAt(t.length() - 1);
                } else {
                    t.append(c);
                }
            }
        }
        return t.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return Objects.equals(f(s), f(t));
    }
}

public class _844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(solution.backspaceCompare(s, t));
    }
}
