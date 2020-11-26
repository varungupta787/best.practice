package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*  56. Merge Intervals */

/*  https://leetcode.com/problems/merge-intervals/  */

/*
*
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*
* */

public class MergeIntervals {
    public  static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> temp = new ArrayList<>();
        temp.add(intervals[0]);
        for(int i=1; i < intervals.length; i++) {
            if(temp.get(temp.size()-1)[1] < intervals[i][0]) {
                temp.add(intervals[i]);
            } else {
                temp.get(temp.size()-1)[1] =
                        Math.max(temp.get(temp.size()-1)[1], intervals[i][1]);
            }
        }

        return temp.toArray(new int[temp.size()][]);
    }
}
