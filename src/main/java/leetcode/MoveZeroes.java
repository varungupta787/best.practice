package leetcode;

/*  283. Move Zeroes    */

/*  https://leetcode.com/problems/move-zeroes/  */

/*
*
* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*
* */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length, curr=0, index =0;


        for(int i=0; i<len; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                if(i != index) {
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}
