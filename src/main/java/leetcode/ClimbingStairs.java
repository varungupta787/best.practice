package leetcode;

/*  70. Climbing Stairs */

/*  https://leetcode.com/problems/climbing-stairs   */

/*
*
* You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*
* */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }

        int[] data = new int[n];

        data[0] = 1;
        data[1] = 2;
        for(int i=2; i<n; i++) {
            data[i] = data[i-1]+ data[i-2];
        }
        return data[n-1];
    }
}
