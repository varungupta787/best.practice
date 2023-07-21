package leetcode;

/*  https://leetcode.com/problems/plates-between-candles/description/   */

/*  2055. Plates Between Candles    */

/*
*
* There is a long table with a line of plates and candles arranged on top of it. You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.

You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles that are in the substring. A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.

For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
Return an integer array answer where answer[i] is the answer to the ith query.



Example 1:

ex-1
Input: s = "**|**|***|", queries = [[2,5],[5,9]]
Output: [2,3]
Explanation:
- queries[0] has two plates between candles.
- queries[1] has three plates between candles.
Example 2:

ex-2
Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
Output: [9,0,0,0,0]
Explanation:
- queries[0] has nine plates between candles.
- The other queries have zero plates between candles.
*
* */

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] result = new int[queries.length];
        int plates = 0, curr = -1;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[n];

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '|') {
                curr = i;
            } else {
                plates += 1;
            }
            left[i] = curr;
            count[i] = plates;
        }

        curr = -1;
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i) == '|') {
                curr = i;
            }
            right[i] = curr;
        }

        int i=0;
        for(int[] query : queries) {
            int leftCandleIndex = right[query[0]];
            int rightCandleIndex = left[query[1]];
            if(leftCandleIndex != -1 && rightCandleIndex != -1) {
                result[i] = Math.max(0,
                        count[rightCandleIndex] - count[leftCandleIndex]);
            }
            i++;
        }
        return result;
    }
}
