package leetcode;

import java.util.Arrays;
import java.util.Random;

/*  497. Random Point in Non-overlapping Rectangles */

/*  https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/   */

/*
*
* Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates.
A point on the perimeter of a rectangle is included in the space covered by the rectangles.
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input:
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output:
[null,[4,1],[4,1],[3,3]]
Example 2:

Input:
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output:
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
*
* */

public class RandomPointInNonOverlappingRectangles {


    public static void main(String[] args) {
        RandomPointInNonOverlappingRectangles obj =
                new RandomPointInNonOverlappingRectangles(new int[][]{
                {-2, -2, -1, -1},
                {1, 0, 3, 0},
        });
        System.out.println(obj.pick());
    }

    int[][] rects;
    int[] offsets;
    int range;
    Random r;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        this.offsets = new int[rects.length];
        this.range = 0;
        r = new Random();

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];

            int x1 = rect[0],
                    y1 = rect[1],
                    x2 = rect[2],
                    y2 = rect[3];

            offsets[i] = range;
            range += (x2 - x1 + 1) * (y2 - y1 + 1);
        }

    }

    public int[] pick() {
        int randIdx = r.nextInt(range),
                rectIdx = Arrays.binarySearch(offsets, randIdx);

        if (rectIdx < 0) {
            rectIdx = Math.abs(rectIdx + 2);
        }

        int[] rect = rects[rectIdx];

        int idx = randIdx - offsets[rectIdx],
                x = rect[0],
                y = rect[1],
                width = rect[2] - rect[0] + 1,
                height = rect[3] - rect[1] + 1,
                row = idx / width,
                col = idx % width;

        return new int[]{x + col, y + row};
    }
}
