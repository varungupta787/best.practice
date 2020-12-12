package leetcode;

/*  378. Kth Smallest Element in a Sorted Matrix    */

/*  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/  */

/*
*
* Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

*
* */

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        int left = matrix[0][0], right = matrix[matrix.length-1][matrix[0].length-1];
        while(left < right) {
            int mid = left + (right-left)/2;
            int count = kthSmallestUtil(matrix, mid);
            if(count < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int kthSmallestUtil(int[][] matrix, int target) {
        int row = 0, m = matrix.length, count = 0,
                n = matrix[0].length, col = matrix[0].length-1;

        while(row < m && col >= 0) {
            if(matrix[row][col] <= target) {
                count += col+1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}
