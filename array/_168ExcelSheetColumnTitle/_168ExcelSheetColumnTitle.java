package array._168ExcelSheetColumnTitle;

class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            char c = (char) ('A' + columnNumber % 26);
            result.insert(0, c);
            columnNumber /= 26;
        }

        return result.toString();

    }
}

public class _168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(28));    // AB
        System.out.println(solution.convertToTitle(701));   // ZY
    }
}
