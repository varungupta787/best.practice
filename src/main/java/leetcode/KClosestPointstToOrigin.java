package leetcode;

/*  https://leetcode.com/problems/k-closest-points-to-origin/description/ */

/*  973. K Closest Points to Origin */

/*
*
* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).



Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
*
* */


import java.util.PriorityQueue;

public class KClosestPointstToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue =
                new PriorityQueue<Point>((a,b) -> (int)(a.d-b.d));
        for(int[] xy : points) {
            queue.add(new Point(xy[0], xy[1]));
        }
        int[][] result = new int[k][2];
        int i=0;
        while(i<k) {
            Point point = queue.remove();
            result[i][0] = point.x;
            result[i][1] = point.y;
            i++;
        }
        return result;
    }

    static class Point {
        int x, y;
        int d;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = distance();
        }

        private int distance() {
            return ((x*x)+(y*y));
        }
    }
}
