/** Game of Life
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length; 
        int n=board[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
            	//count周边有几个live
                int neighbors = getNeighbour(board, i, j);
                //live的情况下
                if(board[i][j]==1){
                    if(neighbors==2 || neighbors==3)
                        board[i][j]=3;
                }else{
                //dies的情况下
                    if(neighbors==3)
                        board[i][j]=2;
                }
            }
        }    
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                board[i][j]= board[i][j]>>1;
            }
        }
    }

    private int getNeighbour(int[][] board, int row, int col){
        int cnt=0;
        //历遍9个以board[row][col]为中心的格子
        for(int i=row-1;i<=row+1;++i){
            for(int j=col-1;j<=col+1;++j){
                if(i>=0 && i<board.length && j>=0 && j<board[0].length){
                    cnt += board[i][j]&1;
                }
            }
        }
        //如果board[row][col]为1，减去
        cnt-=board[row][col]&1;
        return cnt;
    }
}