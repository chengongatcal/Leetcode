public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0){
            return result;
        }
        int num = 0;
        for (int i = 0; i < (n+1)/2; i++){
            for (int j = i; j < n - i; j++){
                result[i][j] = ++num;
            }
            for (int j = i+1; j < n -1 -i; j++){
                result[j][n-1-i] = ++num;
            }
            for (int j = n -1 -i; j >= i && i != n -1-i; j--){
                result[n-1-i][j] = ++num;
            }
            for (int j = n -2 - i; j > i && i != n -1- i; j--){
                result[j][i] = ++num;
            }
        }
        return result;
    }
}