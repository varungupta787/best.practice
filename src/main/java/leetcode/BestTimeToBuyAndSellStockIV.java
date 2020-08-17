package leetcode;

import java.util.Arrays;

/*  188. Best Time to Buy and Sell Stock IV */

/*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/   */

/*
*
* Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
*
* */

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len < 2 || k <= 0) {
            return 0;
        }

        int out = 0;
        if(k >= len/2) {
            for(int i=0; i< len-1; i++) {
                if(prices[i+1] > prices[i]) {
                    out += prices[i+1] - prices[i];
                }
            }
            return out;
        }

        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k];
        for(int i=0; i< len; i++) {
            for(int j=0; j<k; j++) {
                buy[j] = Math.max(buy[j], (j==0) ? - prices[i] : sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k-1];
    }
}