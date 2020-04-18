package leetcode;

import javafx.util.Pair;

import java.util.HashMap;

/*
https://leetcode.com/problems/max-points-on-a-line/     */


/*149. Max Points on a Line       */


/*

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

*/

public class MaximumPointOnLine {
    public int maxPoints(int[][] points) {
        int size = points.length;
        if (size <= 2)
            return size;
        int max = 0;
        for (int i = 0; i < size; i++) {

            HashMap<Pair<Integer, Integer>, Integer> slopeMap = new HashMap<>();
            int vertical = 1;
            int same = 0;
            int currMax = 1;

            for (int j = i + 1; j < size; j++) {
                if (points[i][0] == points[j][0]) {
                    if (points[i][1] == points[j][1]) {
                        same++;
                    } else {
                        vertical++;
                        currMax = Math.max(currMax, vertical);
                    }
                } else {
                    int yDiff = (points[i][1] - points[j][1]);
                    int xDiff = (points[i][0] - points[j][0]);
                    int gcd = gcd(xDiff, yDiff);
                    xDiff /= gcd;
                    yDiff /= gcd;
                    Pair pair = new Pair(xDiff, yDiff);
                    if (slopeMap.containsKey(pair)) {
                        slopeMap.put(pair, slopeMap.get(pair) + 1);
                    } else {
                        slopeMap.put(pair, 2);
                    }
                    currMax = Math.max(currMax, slopeMap.get(pair));
                }
            }
            max = Math.max(currMax + same, max);
        }
        return max;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}