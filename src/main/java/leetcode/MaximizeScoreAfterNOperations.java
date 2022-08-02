package leetcode;

/*  1799. Maximize Score After N Operations */

/*  https://leetcode.com/problems/maximize-score-after-n-operations/    */

/*
*
* You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.

In the ith operation (1-indexed), you will:

Choose two elements, x and y.
Receive a score of i * gcd(x, y).
Remove x and y from nums.
Return the maximum score you can receive after performing n operations.

The function gcd(x, y) is the greatest common divisor of x and y.



Example 1:

Input: nums = [1,2]
Output: 1
Explanation: The optimal choice of operations is:
(1 * gcd(1, 2)) = 1
Example 2:

Input: nums = [3,4,6,8]
Output: 11
Explanation: The optimal choice of operations is:
(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
Example 3:

Input: nums = [1,2,3,4,5,6]
Output: 14
Explanation: The optimal choice of operations is:
(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
*
* */



public class MaximizeScoreAfterNOperations {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int mask = (1<<n)-1;
        int[][] dp = new int[n/2][mask];
        return maxScoreUtil(nums, 1, mask, dp);
    }

    public int maxScoreUtil(int[] nums, int k, int mask, int[][] dp) {
        if(mask == 0) {
            return 0;
        }
        if(dp[k-1][mask-1] == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++) {
                if((mask & (1<<i)) != 0) {
                    for(int j=i+1; j<nums.length; j++) {
                        if((mask & (1<<j)) != 0) {
                            max = Math.max(max, k*gcd(nums[i], nums[j]) +
                                    maxScoreUtil(nums, k+1,
                                            mask^(1<<i)^(1<<j), dp));
                        }
                    }
                }
            }
            dp[k-1][mask-1] = max;
        }
        return dp[k-1][mask-1];
    }
    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
