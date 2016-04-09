/** A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below). 
*/

illustration
   0  1  2
  _________
0| 1  1  1 |
1| 1  2  3 |
2| 1  3  6 |


public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i< m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    count[i][j] = 1;
                } else {
                    count[i][j] = count[i-1][j] + count [i][j-1];
                }
            }
        }
        return count[m-1][n-1];
    }
}