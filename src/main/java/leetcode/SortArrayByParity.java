package leetcode;

/*  905. Sort Array By Parity   */

/*  https://leetcode.com/problems/sort-array-by-parity/ */

/*
*
* Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*
* */

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        if(len < 2) {
            return A;
        }

        int start = -1, i=0;

        while((start < len) && (i<len)) {
            if((A[i] %2) == 0) {
                start++;
                if(i != start) {
                    int temp = A[start];
                    A[start] =  A[i];
                    A[i] = temp;
                }
            }
            i++;
        }

        return A;
    }
}
