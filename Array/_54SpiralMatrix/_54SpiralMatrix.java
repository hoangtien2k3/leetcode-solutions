package Array._54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // duyệt từ trái sang phải
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }
            startRow++;

            // duyệt từ trên xuống dưới
            for (int i = startRow; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            endCol--;

            // duyệt từ phải sang trái (nếu có)
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    list.add(matrix[endRow][i]);
                }
                endRow--;
            }

            // duyệt từ dưới lên (nếu có)
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    list.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }

        return list;
    }
}


public class _54SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution solution = new Solution();
        List<Integer> listResult = solution.spiralOrder(matrix);
        System.out.println(listResult);
    }

}
