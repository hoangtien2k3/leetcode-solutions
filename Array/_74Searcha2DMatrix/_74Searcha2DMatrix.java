package Array._74Searcha2DMatrix;

class Solution {
    public boolean binarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows_length = matrix.length;    // số hàng
        int cols_length = matrix[0].length; // số cột
        int left = 0;                       // giá trị đầu
        int right = rows_length * cols_length - 1;        // gia trị cuối (số lượng phần tử matrix)

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            // mid / cols_length: lấy ra chính xác vị trí hàng của mid
            // mid % cols_length: lấy ra chính xác vị trí cột của mid
            if (matrix[mid / cols_length][mid % cols_length] > target) {
                right = mid - 1;
            } else if (matrix[mid / cols_length][mid % cols_length] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target);
    }
}

public class _74Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        System.out.println(new Solution().searchMatrix(matrix, target));
    }
}
