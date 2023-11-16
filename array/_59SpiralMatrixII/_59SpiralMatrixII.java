package array._59SpiralMatrixII;

/**
 * Row travel
 * Column travel
 * Reverse Row travel
 * Reverse Column travel
 */
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        int x = 0, y = 0;
        int step = 0;

        for (int i = 0; i < n * n; ) {

            // duyệt sang bên trái
            while (y + step < n) {
                i++;
                result[x][y] = i; // i là giá trị tăng liên tiếp
                y++;
            }
            y--;
            x++;

            // duyệt xuống dưới
            while (x + step < n) {
                i++;
                result[x][y] = i;
                x++;
            }
            x--;
            y--;

            // duyệt sang bên phải
            while (y >= step) {
                i++;
                result[x][y] = i;
                y--;
            }
            y++;
            x--;
            step++;

            // duyệt lên trên
            while (x >= step) {
                i++;
                result[x][y] = i;
                x--;
            }
            x++;
            y++;
        }

        return result;
    }
}

public class _59SpiralMatrixII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] result = solution.generateMatrix(n);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
