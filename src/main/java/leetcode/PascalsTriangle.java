package leetcode;

/*  118. Pascal's Triangle  */

/*  https://leetcode.com/problems/pascals-triangle/ */

/*
*
* Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
*
* */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        value.add(1);
        data.add(value);
        if(numRows <= 1) {
            return data;
        }

        for(int i=1; i< numRows; i++) {
            value = new ArrayList<>();
            value.addAll(data.get(i-1));
            value.add(0, 1);
            for(int j=1; j<value.size()-1; j++) {
                value.set(j, value.get(j)+ value.get(j+1));
            }
            data.add(value);
        }
        return data;
    }
}
