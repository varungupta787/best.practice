package leetcode;

/*  221. Maximal Square */

/*  https://leetcode.com/problems/maximal-square/   */

/*
*
* Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*
* */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int result = 0;
        if(row == 0 ) {
            return result;
        }
        int col = matrix[0].length;

        int[][] data = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i != 0 && j != 0 && matrix[i][j] != '0') {
                    data[i][j] = Math.min(data[i - 1][j - 1],
                            Math.min(data[i - 1][j],data[i][j - 1])) + 1;
                } else {
                    data[i][j] = matrix[i][j] - '0';
                }
                result = Math.max(result, data[i][j]);
            }
        }
        return result*result;
    }
}
