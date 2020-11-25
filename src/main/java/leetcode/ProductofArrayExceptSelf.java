package leetcode;

/*  238. Product of Array Except Self   */

/*  https://leetcode.com/problems/product-of-array-except-self/ */

/*
*
* Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*
* */

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int val = nums[0];
        res[0] = 1;
        for(int i=1; i<len; i++) {
            res[i] = val;
            val *= nums[i];
        }

        val = nums[len-1];
        for(int i=len-2; i>=0; i--) {
            res[i] *= val;
            val *= nums[i];
        }

        return res;
    }
}
