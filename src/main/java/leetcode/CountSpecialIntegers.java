package leetcode;

/*  https://leetcode.com/problems/count-special-integers/   */

/*  2376. Count Special Integers    */

/*
*
* We call a positive integer special if all of its digits are distinct.

Given a positive integer n, return the number of special integers that belong to the interval [1, n].



Example 1:

Input: n = 20
Output: 19
Explanation: All the integers from 1 to 20, except 11, are special. Thus, there are 19 special integers.
Example 2:

Input: n = 5
Output: 5
Explanation: All the integers from 1 to 5 are special.
Example 3:

Input: n = 135
Output: 110
Explanation: There are 110 integers from 1 to 135 that are special.
Some of the integers that are not special are: 22, 114, and 131.
*
* */


import java.util.Arrays;

public class CountSpecialIntegers {
    int[][][] dp;
    int[] digit;
    public int countSpecialNumbers(int n) {
        int len = 0, val = n;
        while(val > 0) {
            len++;
            val /= 10;
        }
        dp = new int[len+1][2][(1<<10)-1];
        digit = new int[len+1];
        val = n;
        int i=1;
        while(val > 0) {
            digit[i] = val%10;
            val /= 10;
            i++;
        }

        for(i=0; i<= len; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return countSpecialNumbersUtil(len, 1, 0)-1;
    }

    public int countSpecialNumbersUtil(int pos, int tight, int mask) {
        if(pos == 0) {
            return 1;
        }

        if(dp[pos][tight][mask] != -1) {
            return dp[pos][tight][mask];
        }

        int count= 0;
        int limit = (tight == 1) ? digit[pos] : 9;
        for(int i=0; i<=limit; i++) {
            if((mask & (1<<i)) != 0) {
                continue;
            }
            count += countSpecialNumbersUtil(pos-1, tight == 1 &&
                    i == limit ? 1 : 0, (i ==0 &&
                    mask==0)? mask : mask|(1<<i));
        }
        dp[pos][tight][mask] = count;
        return dp[pos][tight][mask];
    }
}