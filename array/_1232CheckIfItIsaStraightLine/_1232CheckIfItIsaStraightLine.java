package array._1232CheckIfItIsaStraightLine;

class Solution {
    public static int check(int a, int b) {
        return a - b;
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int index1 = coordinates[1][1] - coordinates[0][1]; // lấy tra chênh lệch x giữa tọa độ 1 và tọa độ 2
        int index2 = coordinates[1][0] - coordinates[0][0]; // lấy tra chênh lệch y giữa tọa độ 1 và tọa độ 2

        for (int i = 2; i < coordinates.length; i++) {
            if (index1 * check(coordinates[i][0], coordinates[0][0]) != index2 * check(coordinates[i][1], coordinates[0][1])) {
                return false;
            }
        }
        return true;
    }
}

public class _1232CheckIfItIsaStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(Solution.checkStraightLine(coordinates));
    }
}