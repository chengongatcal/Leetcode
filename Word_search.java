/** Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false. */

public class Solution {
    public boolean exist(char[][] board, String word) {
        int col = board[0].length;
        int row = board.length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (bfs(board, i, j, word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(char[][] board, int i, int j, String s){
        if(i<0 || i>= board.length || j<0|| j>= board[0].length
        ||board[i][j] != s.charAt(0)){
            return false;
        }
        if (s.length() == 1){
            return true;
        }
        String sub = s.substring(1);
        board[i][j] = '#';
        boolean ret = bfs(board, i - 1, j, sub)|| bfs(board, i+1, j, sub)
        || bfs(board, i, j+1, sub)||bfs(board, i, j-1, sub);
        board[i][j] = s.charAt(0);
        return ret;
    }
}