package leetcode;

/*  300. Longest Increasing Subsequence */

/*  https://leetcode.com/problems/longest-increasing-subsequence/   */

/*
*
* Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*
* */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        int max= 0;

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    if((temp[j]+1) > temp[i]) {
                        temp[i] = temp[j]+1;
                    }
                }
            }
            if(max < temp[i]) {
                max = temp[i];
            }
        }
        return max+1;
    }
}
