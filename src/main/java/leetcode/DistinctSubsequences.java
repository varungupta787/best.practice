package leetcode;

/*  115. Distinct Subsequences  */

/*  https://leetcode.com/problems/distinct-subsequences/    */

/*
*
* Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

The test cases are generated so that the answer fits on a 32-bit signed integer.



Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
*
* */

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {

        int n1 = s.length(), n2 = t.length();
        int[][] dp = new int[2][n2 + 1];
        int index = 0;
        dp[0][0] = 1;
        dp[1][0] = 1;
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[index][j] = dp[index ^ 1][j];
                if (sArr[i - 1] == tArr[j - 1]) {
                    dp[index][j] += dp[index ^ 1][j - 1];
                }
            }
            index ^= 1;
        }
        return dp[index ^ 1][n2];
    }
}
