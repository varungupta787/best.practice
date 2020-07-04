package leetcode;

/*  264. Ugly Number II */

/*  https://leetcode.com/problems/ugly-number-ii/   */

/*
*
* Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
*
* */

public class UglyNumberII {
    static UglyNumber uglyNumber = new UglyNumber ();

    public int nthUglyNumber (int n) {

        return uglyNumber.dp[n - 1];
    }
}


class UglyNumber {

    int[] dp;

    public UglyNumber () {

        dp = new int[1690];
        dp[0] = 1;
        int countTwo = 0, countThree = 0, countFive = 0;

        for (int i = 1; i < 1690; i++) {
            int currTwo = dp[countTwo] * 2;
            int currThree = dp[countThree] * 3;
            int currFive = dp[countFive] * 5;

            dp[i] = Math.min (currTwo, Math.min (currThree, currFive));

            if (dp[i] == currTwo) {
                ++countTwo;
            }
            if (dp[i] == currThree) {
                ++countThree;
            }
            if (dp[i] == currFive) {
                ++countFive;
            }
        }
    }
}

