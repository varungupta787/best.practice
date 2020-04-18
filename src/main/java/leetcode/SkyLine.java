package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*218. The Skyline Problem*/

/*https://leetcode.com/problems/the-skyline-problem/*/

/**
 A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings Skyline Contour
 The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

 For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

 Notes:

 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */


class SkyLine {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> resultList = new ArrayList<>();
        int size = buildings.length;
        ArrayList<Building> list = new ArrayList<>();
        int k=0;

        for(int i=0; i<size; i++) {
            int[] build = buildings[i];
            list.add(new Building(build[0], build[2], true));
            list.add(new Building(build[1], build[2], false));
        }

        Collections.sort(list);
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);
        int listSize = list.size();
        for(int i=0; i<listSize; i++) {
            Building building = list.get(i);
            int maxHeight = queue.lastKey();
            if(building.start) {
                queue.compute(building.height, (key, value) -> {
                    if(value != null) {
                        return value+1;
                    } else {
                        return 1;
                    }
                });

            } else {

                queue.compute(building.height, (key, value) -> {

                    if(value == 1) {
                        return null;
                    }
                    return value-1;
                });
            }
            int currHeight = queue.lastKey();
            if(currHeight != maxHeight) {

                List<Integer> out = new ArrayList<>();
                out.add(building.pos);
                out.add(currHeight);
                resultList.add(out);
            }
        }
        return resultList;
    }

    static class Building implements Comparable<Building> {

        int pos;
        int height;
        boolean start;

        public Building(int pos, int height, boolean start) {
            this.pos = pos;
            this.height = height;
            this.start = start;
        }

        @Override
        public int compareTo(Building o2) {

            if(this.pos != o2.pos) {
                return this.pos - o2.pos;
            } else {
                return (this.start ? -this.height : this.height) -
                        (o2.start ? -o2.height : o2.height);
            }
        }
    }
}