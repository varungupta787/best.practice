package leetcode;

/*  48. Rotate Image    */

/*  https://leetcode.com/problems/rotate-image/ */

/*
*
* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Example 3:

Input: matrix = [[1]]
Output: [[1]]
Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]
*
* */

public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;

        int rowStart = 0, rowEnd = n-1, colStart = 0,colEnd = n-1;
        while(n>1) {
            for(int i=0; i<n-1; i++) {
                int top = matrix[rowStart][colStart+i];
                matrix[rowStart][colStart+i] = matrix[rowEnd-i][colStart];
                matrix[rowEnd-i][colStart] = matrix[rowEnd][colEnd-i];
                matrix[rowEnd][colEnd-i] = matrix[rowStart+i][colEnd];
                matrix[rowStart+i][colEnd] = top;
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
            n -= 2;
        }
    }
}
