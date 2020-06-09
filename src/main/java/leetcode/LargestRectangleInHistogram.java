package leetcode;

import java.util.Stack;

/*  84. Largest Rectangle in Histogram  */

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/   */

/*
*
* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10
*
* */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int area = 0;
        if(len == 0) {
            return area;
        }
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while (i < len) {
            if (stk.isEmpty() || heights[stk.peek()] < heights[i]) {
                stk.push(i);
                i++;
            } else {
                int h = heights[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                area = Math.max(h * w, area);
            }
        }

        while (!stk.isEmpty()) {
            int h = heights[stk.pop()];
            int w = stk.isEmpty() ? i : i - stk.peek() - 1;
            area = Math.max(h * w, area);
        }
        return area;
    }
}
