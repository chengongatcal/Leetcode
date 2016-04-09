/** An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] count = new int[col];
        count[0] = 1;

        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (obstacleGrid[i][j] == 1){
                    count[j] = 0;
                } else if (j > 0) {
                    count[j] += count[j-1];
                }
            }
        }
        return count[col-1];
    }
}