package leetcode;

/*  983. Minimum Cost For Tickets   */

/*  https://leetcode.com/problems/minimum-cost-for-tickets/ */

/*
*
* In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.



Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
*
* */

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] travelCost = new int[days[days.length-1]+1];

        // Set for identifying travel dates
        Set<Integer> set = new HashSet<>();
        for(int day: days){
            set.add(day);
        }

        for(int i=1;i<travelCost.length;i++){
            if(!set.contains(i)) {
                // Non travel day simply copy the value from previous day
                travelCost[i] =travelCost[i-1];
            } else{
                int priceUsingDailyPass = travelCost[i-1]+ costs[0];

                int priceUsingWeeklyPass = costs[1];
                if(i>=7){
                    priceUsingWeeklyPass = travelCost[i-7]+ costs[1];
                }


                int priceUsingMonthlyPass = costs[2];
                if(i>=30){
                    priceUsingMonthlyPass = travelCost[i-30]+ costs[2];
                }
                // comparison between the possible 3 values
                travelCost[i]= Math.min(priceUsingMonthlyPass, Math.min(priceUsingDailyPass,priceUsingWeeklyPass));
            }
        }

        return travelCost[travelCost.length-1];
    }
}
