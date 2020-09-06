package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  835. Image Overlap  */

/*  https://leetcode.com/problems/image-overlap/    */

/*
*
* Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes:

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
*
* */

public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;

        int[][] coordsOverlap = new int[N * 2][N * 2];

        List<int[]> coordsA = new ArrayList<>();
        List<int[]> coordsB = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (A[y][x] == 1) {
                    coordsA.add(new int[]{y, x});
                }

                if (B[y][x] == 1) {
                    coordsB.add(new int[]{y, x});
                }
            }
        }

        for (int[] coords : coordsA) {
            for (int[] next : coordsB) {
                coordsOverlap[N + coords[0] - next[0]][N + coords[1] - next[1]]++;
            }
        }

        int maxOverlap = 0;
        for (int[] row : coordsOverlap) {
            for (int overlap : row) {
                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }
        return maxOverlap;
    }
}
