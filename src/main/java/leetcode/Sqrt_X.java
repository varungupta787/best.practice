package leetcode;

/*  69. Sqrt(x) */

/*  https://leetcode.com/problems/sqrtx/    */

/*
*
* Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.



Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
*
* */

public class Sqrt_X {
    public int mySqrt(int x) {
        long low= 1;
        long high= x;
        long ans =0;

        while(low<=high){
            long mid= (low+high)/2;
            long msq= mid*mid;
            if(msq==x){
                return (int)mid;
            }
            else if(msq>x){
                high= mid-1;
            }
            else{
                low= mid+1;
                ans= mid;
            }
        }
        return (int)ans;
    }
}
