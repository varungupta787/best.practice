package leetcode;

/*  Best Position for a Service Centre  */

/*  https://leetcode.com/problems/best-position-for-a-service-centre/   */

/*
*
* A delivery company wants to build a new service centre in a new city. The company knows the positions of all the customers in this city on a 2D-Map and wants to build the new centre in a position such that the sum of the euclidean distances to all customers is minimum.

Given an array positions where positions[i] = [xi, yi] is the position of the ith customer on the map, return the minimum sum of the euclidean distances to all customers.

In other words, you need to choose the position of the service centre [xcentre, ycentre] such that the following formula is minimized:


Answers within 10^-5 of the actual value will be accepted.



Example 1:


Input: positions = [[0,1],[1,0],[1,2],[2,1]]
Output: 4.00000
Explanation: As shown, you can see that choosing [xcentre, ycentre] = [1, 1] will make the distance to each customer = 1, the sum of all distances is 4 which is the minimum possible we can achieve.
Example 2:


Input: positions = [[1,1],[3,3]]
Output: 2.82843
Explanation: The minimum possible sum of distances = sqrt(2) + sqrt(2) = 2.82843
Example 3:

Input: positions = [[1,1]]
Output: 0.00000
Example 4:

Input: positions = [[1,1],[0,0],[2,0]]
Output: 2.73205
Explanation: At the first glance, you may think that locating the centre at [1, 0] will achieve the minimum sum, but locating it at [1, 0] will make the sum of distances = 3.
Try to locate the centre at [1.0, 0.5773502711] you will see that the sum of distances is 2.73205.
Be careful with the precision!
Example 5:

Input: positions = [[0,1],[3,2],[4,5],[7,6],[8,9],[11,1],[2,12]]
Output: 32.94036
Explanation: You can use [4.3460852395, 4.9813795505] as the position of the centre.


Constraints:

1 <= positions.length <= 50
positions[i].length == 2
0 <= positions[i][0], positions[i][1] <= 100
*
* */

public class BestPositionForServiceCentre {

    public double getMinDistSum(int[][] positions) {
        double minDist = Integer.MAX_VALUE;
        double step = 50, x = 50, y = 50, minX = 0, minY = 0;

        while(step > 10e-4){
            for(double i = x-step; i <= (x+ step); i += step/100) {
                for(double j = y-step; j <= (y+step); j += step/100) {
                    double val = 0;
                    for(int k= 0; k < positions.length; k++) {
                        val += getDistance(i, j, positions[k][0], positions[k][1]);
                    }
                    if(minDist > val) {
                        minX = i;
                        minY = j;
                        minDist = val;
                    }
                }
            }
            step /= 100;
            x = minX;
            y = minY;
        }
        return minDist;
    }

    private double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
    }
}
