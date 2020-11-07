package leetcode;

/*  152. Maximum Product Subarray   */

/*  https://leetcode.com/problems/maximum-product-subarray/ */

/*
*
* Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*
* */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        int max = 1, min =1;
        for(int i=0;i<nums.length;i++){
            int prod1 = max*nums[i], prod2 = min*nums[i];
            max = Math.max(nums[i], Math.max(prod1, prod2));
            min = Math.min(nums[i], Math.min(prod1, prod2));
            res = Math.max(res, max);
        }
        return res;
    }
}
