package leetcode;

import java.util.Arrays;
import java.util.Stack;

 /* Graham scan finds all vertices of the convex hull ordered along its boundary.   */

/*  587. Erect the Fence*/

/*  https://leetcode.com/problems/erect-the-fence/    */

/*  There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.



Example 1:

Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:

Example 2:

Input: [[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
Explanation:

Even you only have trees in a line, you need to use rope to enclose them.     */


public class ConvexHull {
    public static void main(String[] args) {
        int[][] aa = new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        int[][] result = new ConvexHull().outerTrees(aa);
        for (int[] val : result) {
            System.out.println("[" + val[0] + "," + val[1] + "]");
        }
    }
    public int[][] outerTrees(int[][] points) {
        Point[] input = new Point[points.length];
        int index = 0;
        for (int[] i : points) {
            input[index++] = new Point(i[0], i[1]);
        }
        return findConvexHull(input);
    }

    public int[][] findConvexHull(Point[] points) {

        if (points.length < 2) {
            int[][] out = new int[points.length][2];
            for(int i=0; i<points.length; i++) {
                out[i][0] = points[i].x;
                out[i][1] = points[i].y;
            }
            return out;
        }

        //find the lowest point in the plane. If there are multiple lowest points
        //then pick the leftmost one.
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (start.y > points[i].y) {
                start = points[i];
            } else if (start.y == points[i].y && start.x > points[i].x) {
                start = points[i];
            }
        }

        sortAndHandleCollinear(points, start);

        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < points.length; i++) {
            Point top = stack.pop();

            /*  pop points which are making clockwise angle   */
            while (crossProduct(stack.peek(), top, points[i]) == 1) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[i]);
        }

        int stkSize = stack.size();
        int[][] out = new int[stkSize][2];
        for(int i=0; i<stkSize; i++) {
            Point pp = stack.pop();
            out[i][0] = pp.x;
            out[i][1] = pp.y;
        }
        return out;
    }

    private int crossProduct(Point a, Point b, Point c) {

        /*int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return y2 * x1 - y1 * x2;*/

        /*
        *  0 = Collinear
        *  1 = Clockwise Angle
        * -1 = Anticlockwise Angle
        *
        **/

        int val = (((c.x - b.x) * (b.y - a.y)) -
                ((c.y - b.y) * (b.x - a.x)));
        if (val == 0) return 0;
        return (val > 0) ? 1 : -1;


    }

    private void sortAndHandleCollinear(Point[] points, Point start) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1 == start) {
                return -1;
            }
            if (p2 == start) {
                return 1;
            }
            int cp = crossProduct(start, p1, p2);
            if (cp == 0) {
                return distance(start, p1, p2);
            } else {
                return cp;
            }
        });

        //make sure last collinear points are in reverse order of distance.
        Point p = points[0], q = points[points.length - 1];
        int i = points.length - 2;
        while (i >= 0 && crossProduct(p, q, points[i]) == 0) {
            i--;
        }

        // reverse sort order of collinear points in the end positions
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point tmp = points[l];
            points[l] = points[h];
            points[h] = tmp;
        }
    }

    private int distance(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return (x1*x1 + y1*y1) - (x2*x2 + y2*y2 );
        //return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}