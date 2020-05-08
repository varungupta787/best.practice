package leetcode;

/*
* You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
* Check if these points make a straight line in the XY plane.

    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false

Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

*
*
* */

public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {

        int size = coordinates.length;
        if (size == 2)
            return true;
        double yDiff1 = (coordinates[1][1] - coordinates[0][1]);
        double xDiff1 = (coordinates[1][0] - coordinates[0][0]);
        if (xDiff1 == 0 && yDiff1 != 0) {
            return false;
        }
        double slope = yDiff1 / xDiff1;
        for (int i = 2; i < size; i++) {
            double yDiff2 = (coordinates[i][1] - coordinates[0][1]);
            double xDiff2 = (coordinates[i][0] - coordinates[0][0]);
            if (xDiff2 == 0 && yDiff2 != 0) {
                return false;
            }
            double tempSlope = yDiff2 / xDiff2;
            if (tempSlope != slope)
                return false;
        }
        return true;
    }
}