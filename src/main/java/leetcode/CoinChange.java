package leetcode;

/*  322. Coin Change    */

/*  https://leetcode.com/problems/coin-change/  */

/*
*
* You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*
* */


public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int len = coins.length;
        int[] data = new int[amount + 1];
        for(int j = 1; j <= amount; j++) {
            data[j] = -1;
        }
        data[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (data[j - coins[i]] != -1) {
                    if (data[j] == -1) {
                        data[j] = data[j - coins[i]] + 1;
                    } else {
                        data[j] = Math.min(data[j], data[j - coins[i]] + 1);
                    }
                }
            }
        }
        return data[amount] == 0 ? -1 : data[amount];
    }
}
