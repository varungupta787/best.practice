package leetcode;

/*  231. Power of Two   */

/*  https://leetcode.com/problems/power-of-two/ */

/*
*
* Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
*
* */

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}
