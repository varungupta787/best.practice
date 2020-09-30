package leetcode;

/*  41. First Missing Positive  */

/*  https://leetcode.com/problems/first-missing-positive/   */

/*
*
* Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Follow up:

Your algorithm should run in O(n) time and uses constant extra space.
*
* */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0; i< n; i++) {
            if(nums[i] > n || nums[i] <= 0) {
                nums[i] = n+1;
            }
        }

        for(int i=0; i< n; i++) {
            int index = Math.abs(nums[i]);
            if(index <= n ) {
                index--;
                if(nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
        }

        for(int i=0; i< n; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return n+1;
    }
}
