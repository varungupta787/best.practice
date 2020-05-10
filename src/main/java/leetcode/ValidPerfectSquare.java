package leetcode;

/*  367. Valid Perfect Square   */

/*  https://leetcode.com/problems/valid-perfect-square/ */


/*
* Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
*
* */

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        long start = 1;
        long end = num;
        while (start<= end) {
            long mid = (start + end)/2;
            long midSqr = mid*mid;
            if(midSqr == num){
                return true;
            } else if(midSqr < num) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
