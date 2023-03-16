package Array.ValidSudoku;

import static java.lang.System.exit;

class Solution {
    private void printSolution(int[][] s) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

    void solveSudoku(int S[][9], int x, int y) {
        if (y == 9) {
            if (x == 8) {
                printSolution(S);
                exit(0);
            } else {
                solveSudoku(S, x+1, 0);
            }
        } else if (S[x][y] == 0){
            for(int k=1; k <= 9; k++) {
                if (checkValid(S, x, y, k)) {
                    S[x][y] = k;
                    solveSudoku(S, x, y+1);
                    S[x][y] = 0;
                }
            }
        } else {
            solveSudoku(S, x, y+1);
        }
    }

    Boolean checkValid(int S[][9], int x, int y, int k) {
        for(int i = 0; i < 9; i++) {
            if (S[x][i] == k)
                return false;
        }
        for(int i = 0; i < 9; i++) {
            if (S[i][y] == k)
                return false;
        }

        int a = x/3, b = y/3;
        for(int i = 3*a; i < 3*a+3; i++) {
            for(int j = 3*y; j < 3*y+3; j++) {
                if (S[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}


public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
