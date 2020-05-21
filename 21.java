// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

// Example 1:
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation: 
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.

class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null )
            return 0;

          int  n = matrix.length, m = matrix[0].length;

          int[][] dp = new int[n + 1][m + 1];
            int sum=0;
          for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
              if (matrix[i - 1][j - 1] == 1) {
                  int cur = 1;
                cur += Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
 
                  dp[i][j]=cur;sum += cur;
                
              }
            }   
          } 
        
        return sum;
    }
}