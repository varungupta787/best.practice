package leetcode;

/*  https://leetcode.com/problems/grumpy-bookstore-owner/description/   */

/*  1052. Grumpy Bookstore Owner    */

/*
*
*There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.



Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
Example 2:

Input: customers = [1], grumpy = [0], minutes = 1
Output: 1
*
*/


public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, result = 0, n = customers.length;
        for(int i=0; i<n; i++) {
            if(grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int i=0;
        while(i<minutes && i<n) {
            if(grumpy[i] == 1) {
                sum = Math.max(sum, customers[i]+sum);
            }
            i++;
        }

        result = sum;

        while(i<n) {
            if(grumpy[i] == 1) {
                sum += customers[i];
            }

            if(i-minutes >= 0 && grumpy[i-minutes] == 1) {
                sum -= customers[i-minutes];
            }
            i++;
            result = Math.max(result, sum);
        }
        return result;
    }
}
