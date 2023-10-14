package Array._242ValidAnagram;

import java.util.Arrays;

class Solution {
    public static boolean isAnagram(String s, String t) {
        char[] ss1 = s.toCharArray();
        Arrays.sort(ss1);
        String s1 = new String(ss1);

        char[] ss2 = t.toCharArray();
        Arrays.sort(ss2);
        String s2 = new String(ss2);

        return s1.equalsIgnoreCase(s2);
    }
}

public class _242ValidAnagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        System.out.println(Solution.isAnagram(s, t));
    }
}