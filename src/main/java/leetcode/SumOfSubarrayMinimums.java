package leetcode;

/*  907. Sum of Subarray Minimums   */

/*  https://leetcode.com/problems/sum-of-subarray-minimums/ */

/*
*
* Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
*
* */


import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int n = arr.length;
        long minSum = 0;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Arrays.fill(leftMin, arr.length);
        Arrays.fill(rightMin, -1);
        for(int i=0; i<arr.length; i++) {
            while(!left.isEmpty() && arr[i] < arr[left.peek()]) {
                leftMin[left.pop()] = i;
            }
            left.push(i);
        }
        for(int i=arr.length-1; i>=0; i--) {
            while(!right.isEmpty() && arr[i] <= arr[right.peek()]) {
                rightMin[right.pop()] = i;
            }
            right.push(i);
        }
        int leftVal = 0, rightVal = 0;
        for(int i=0; i<arr.length; i++) {
            leftVal = i-leftMin[i];
            rightVal = rightMin[i] - i;
            long prod = (leftVal*rightVal);
            prod = (arr[i]*prod);
            minSum = (minSum + prod)%1000000007;
        }

        return (int)minSum;
    }
}
