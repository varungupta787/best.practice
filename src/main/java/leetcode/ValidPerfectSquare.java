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

        if(num == 1)
            return true;
        else {
            int i = 1;
            if(num %2 == 0) {
                i=2;
            } else {
                i=3;
            }
            for(;i<=num/2; i+=2) {
                if((num % (i*i)) == 0) {
                    return isPerfectSquare(num/(i*i));
                }
            }
            return false;
        }
    }
}
