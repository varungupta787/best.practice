package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  967. Numbers With Same Consecutive Differences  */

/*  https://leetcode.com/problems/numbers-with-same-consecutive-differences/    */

/*
*
* Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.



Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
*
* */

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> result = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            dfs(N - 1, num, K, result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int N, int num, int K, List<Integer> result) {
        if (N == 0) {
            result.add(num);
            return;
        }

        if (num % 10 + K < 10)
            dfs(N - 1, num * 10 + num % 10 + K, K, result);

        if (K > 0 && num % 10 - K >= 0)
            dfs(N - 1, num * 10 + num % 10 - K, K, result);
    }
}