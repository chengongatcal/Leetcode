/** 64. Minimum Path Sum  
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
*/



public class Solution {
    public int minPathSum(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(i == 0 && j==0){
                    continue;
                }else if (i == 0 && j != 0){
                    grid[i][j] += grid[i][j-1]; 
                }else if (i != 0 && j == 0){
                    grid[i][j] +=grid[i-1][j];
                }
                else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[y-1][x-1];
    }
}