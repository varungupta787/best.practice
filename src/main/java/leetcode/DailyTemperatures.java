package leetcode;

/*  739. Daily Temperatures */

/*  https://leetcode.com/problems/daily-temperatures/   */

/*
*
* Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*
* */


public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] max = new int[len];
        max[len-1] = -1;

        for(int i=len-2; i>=0; i--) {
            if(T[i] < T[i+1]) {
                max[i] = i+1;
            } else {
                max[i] = -1;
                int index = max[i+1];
                while(index != -1) {
                    if(T[i] < T[index]) {
                        max[i] = index;
                        break;
                    } else {
                        index = max[index];
                    }
                }
            }
        }

        int[] res = new int[len];
        for(int i=0; i<len; i++) {
            res[i] = (max[i] != -1) ? (max[i]-i) : 0;
        }
        return res;
    }
}
