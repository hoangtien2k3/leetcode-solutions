package Array._17LetterCombinationsOfAPhoneNumber;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public void backtrackingPhoneNumber(List<String> temp, List<String> allList, String digits, String check, int index) {
        if (digits.length() == check.length()) {
            allList.add(check);
            return;
        }
        String currentListNumber = temp.get(digits.charAt(index) - '0');
        for(int i = 0; i < currentListNumber.length(); i++) {
            backtrackingPhoneNumber(temp, allList, digits, check + currentListNumber.charAt(i), index + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> allList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("");
        temp.add("");
        temp.add("abc");
        temp.add("def");
        temp.add("ghi");
        temp.add("jkl");
        temp.add("mno");
        temp.add("pqrs");
        temp.add("tuv");
        temp.add("wxyz");

        backtrackingPhoneNumber(temp, allList, digits, "", 0);
        return allList;
    }
}


public class _17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";

        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(digits));
    }
}
