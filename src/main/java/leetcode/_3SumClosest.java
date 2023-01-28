package leetcode;

/*  16. 3Sum Closest    */

/*  https://leetcode.com/problems/3sum-closest/description/ */

/*
*
* Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

*
* */


import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
            int j=i+1, k=nums.length-1;
            boolean found = false;
            while(j<k) {
                int val = nums[i]+nums[j]+nums[k] - target;
                if(Math.abs(val) < (diff)) {
                    diff = Math.abs(val);
                    sum = nums[i]+nums[j]+nums[k];
                }
                if(nums[i]+nums[j]+nums[k]< target) {
                    j++;
                } else if(nums[i]+nums[j]+nums[k] > target) {
                    k--;
                } else {
                    found = true;
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        return sum;
    }
}
