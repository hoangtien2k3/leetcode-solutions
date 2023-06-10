package Array._79WordSearch;

class Solution {
    private boolean dfs(int i, int j, int index, boolean[][] visited, char[][] board, String word){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(word.charAt(index) != board[i][j]){
            return false;
        }
        if(visited[i][j] ){
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(i + 1, j, index + 1, visited, board, word);
        res = res || dfs(i - 1, j, index + 1, visited, board, word);
        res = res || dfs(i, j + 1, index + 1, visited, board, word);
        res = res || dfs(i, j - 1, index + 1, visited, board, word);
        visited[i][j] = false;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(dfs(i, j, 0, visited, board, word)){
                    return true;
                }
            }
        }
        return false;
    }
}

public class _79WordSearch {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] bourd = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";

        System.out.println(solution.exist(bourd, word));
    }
}
