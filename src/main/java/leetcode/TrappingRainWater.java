package leetcode;

/*  42. Trapping Rain Water */

/*  https://leetcode.com/problems/trapping-rain-water/  */

/*
*
* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*
* */


public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        if(height.length == 0) {
            return result;
        }
        int left = 0, right = height.length-1;
        int lMax = 0, rMax = 0;

        while(left <= right) {
            if(height[left] < height[right]) {
                if(height[left] > lMax) {
                    lMax = height[left];
                } else {
                    result += lMax - height[left];
                }
                left++;
            } else {
                if(height[right] > rMax) {
                    rMax = height[right];
                } else {
                    result += rMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}
