package leetcode;

/*  54. Spiral Matrix   */

/*  https://leetcode.com/problems/spiral-matrix/    */

/*
*
* Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*
* */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int left= 0, top = 0, right = m-1, bottom = n-1, count=0;
        while(left<=right && top<=bottom) {
            for(int i=left; i<=right ; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if(top > bottom) {
                return res;
            }

            for(int i=top; i<=bottom; i++) {
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            if(left > right) {
                return res;
            }

            for(int i=right; i>=left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom) {
                return res;
            }

            for(int i=bottom; i>=top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if(left > right) {
                return res;
            }

        }
        return res;
    }
}
