package leetcode;

import java.util.Arrays;

/*  1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts    */

/*  https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/   */

/*
*
*You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.



Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:


Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9
*
* */

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hLen = horizontalCuts.length;
        int vLen = verticalCuts.length;

        int maxH = 0;
        for(int i=0; i<=hLen; i++) {
            if(i==0) {
                maxH = Math.max(maxH, horizontalCuts[i] - 0);
            } else if(i == hLen) {
                maxH = Math.max(maxH, h - horizontalCuts[i-1]);
            } else {
                maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i-1]);
            }
        }

        int res = 0;

        int maxV = 0;
        for(int j=0; j<=vLen; j++) {
            if(j==0) {
                maxV = Math.max(maxV, verticalCuts[j]-0);
            } else if(j == vLen) {
                maxV = Math.max(maxV, w-verticalCuts[j-1]);
            } else {
                maxV = Math.max(maxV, verticalCuts[j] - verticalCuts[j-1]);
            }
        }

        return (int)(((long)maxH*maxV)%1000000007);
    }
}
