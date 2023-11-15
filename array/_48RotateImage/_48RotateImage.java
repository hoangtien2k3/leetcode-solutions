package array._48RotateImage;

class Solution {
    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int[][] arr = new int[m][];
        for(int i = 0; i < m; i++) {
            arr[i] = new int[matrix[i].length];
        }


        int k = 0;
        for(int i = 0; i < matrix.length; i++) {
            k = matrix[i].length - 1;
            for(int j = 0; j < matrix[i].length; j++) {
                arr[i][j] = matrix[k][i];
                k--;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
}

public class _48RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8 , 9}};
        Solution solution = new Solution();
        solution.rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
