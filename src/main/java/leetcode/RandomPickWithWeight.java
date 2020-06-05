package leetcode;

/*  528. Random Pick with Weight    */

/*  https://leetcode.com/problems/random-pick-with-weight/  */

/*
*
* Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input:
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input:
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
*
* */


public class RandomPickWithWeight {

    int[] w_sum;

    public RandomPickWithWeight(int[] w) {
        w_sum = new int[w.length];
        int sum = 0;
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            w_sum[i] = sum;
        }
    }

    public int pickIndex() {
        double target = w_sum[w_sum.length - 1] * Math.random();
        int si = 0, ei = w_sum.length - 1;
        int res = -1;
        while(si <= ei){
            int mid = (si + (ei - si) / 2);
            if(target < w_sum[mid]){
                res = mid;
                ei = mid - 1;
            }
            else{
                si = mid + 1;
            }
        }
        return res;
    }