package leetcode;

/*  581. Shortest Unsorted Continuous Subarray  */

/*  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/    */

/*
*
* Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
*
* */

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int start = -1;
        int end = -2;

        int min = nums[n-1];
        int max = nums[0];

        for(int i=1;i<n;i++){
            max = Math.max(max,nums[i]);
            if(nums[i] < max) end = i;
        }

        for(int i = n-2;i>=0;i--){
            min = Math.min(min,nums[i]);
            if(nums[i]>min) start = i;
        }

        return end - start + 1;
    }
}
