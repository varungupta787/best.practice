package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  119. Pascal's Triangle II   */

/*  https://leetcode.com/problems/pascals-triangle-ii/  */

/*
*
* Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*
* */

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(0, 1);
            for (int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
