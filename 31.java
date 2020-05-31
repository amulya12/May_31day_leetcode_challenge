// Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

// You have the following 3 operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
// Example 1:

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

public class Solution {
	public  int minDistance(String word1, String word2) {
		//Check if any string is null or 0 size.It is kind of ugly...
		int row = 0;
		int col = 0;

		if (word1 != null)
			row = word1.length();
		if (word2 != null)
			col = word2.length();

		if (row == 0 || col == 0)
			return Math.max(row, col);

		int[][] matrix = new int[row+1][col+1];

		for (int i=0;i<=row;i++)
			matrix[i][0]=i;
		for (int i=0;i<=col;i++)
			matrix[0][i]=i;
		
		
		for (int i=1;i<=row;i++){
			for (int j=1;j<=col;j++){
			    if (word1.charAt(i-1)==word2.charAt(j-1))
			        matrix[i][j]=matrix[i-1][j-1];//Remove and Add operation are not applicable.
			    else 
			        matrix[i][j]=Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]),matrix[i-1][j-1])+1;
			}			
		}
		return matrix[row][col];
	} 
}