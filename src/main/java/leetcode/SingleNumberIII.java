package leetcode;

/*  260. Single Number III  */

/*  https://leetcode.com/problems/single-number-iii/    */

/*
*
* Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*
* */

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int val = 0;
        int[] out = new int[2];
        for(int num : nums) {
            val ^= num;
        }
        val &= -val;
        for(int num : nums) {
            if((val & num) == 0) {
                out[0] =out[0] ^ num;
            } else {
                out[1] = out[1]^ num;
            }
        }
        return out;
    }
}
