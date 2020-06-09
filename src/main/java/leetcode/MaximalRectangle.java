package leetcode;

import java.util.Stack;

/*  85. Maximal Rectangle   */

/*  https://leetcode.com/problems/maximal-rectangle/    */

/*
*
* Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*
* */


public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }

        int col = matrix[0].length;
        int[] height = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            area = Math.max(area, getMaxArea(height));
        }
        return area;
    }

    private int getMaxArea(int[] height) {
        int area = 0;
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        int len = height.length;
        while (i < len) {
            if (stk.isEmpty() || height[stk.peek()] < height[i]) {
                stk.push(i);
                i++;
            } else {
                int h = height[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                area = Math.max(h * w, area);
            }
        }

        while (!stk.isEmpty()) {
            int h = height[stk.pop()];
            int w = stk.isEmpty() ? i : i - stk.peek() - 1;
            area = Math.max(h * w, area);
        }
        return area;
    }
}
