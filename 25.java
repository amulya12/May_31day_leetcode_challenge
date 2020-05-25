// We write the integers of A and B (in the order they are given) on two separate horizontal lines.
// Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
// A[i] == B[j];
// The line we draw does not intersect any other connecting (non-horizontal) line.
// Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
// Return the maximum number of connecting lines we can draw in this way.

// Example 1:
// Input: A = [1,4,2], B = [1,2,4]
// Output: 2
// Explanation: We can draw 2 uncrossed lines as in the diagram.
// We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
    
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        
        for(int i = A.length - 1; i >= 0; i--){
            for(int j = B.length - 1; j >= 0; j--){
                dp[i][j] = (A[i] == B[j] 
                                ? dp[i + 1][j + 1] + 1 
                                : Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        
        return dp[0][0];
    }
}