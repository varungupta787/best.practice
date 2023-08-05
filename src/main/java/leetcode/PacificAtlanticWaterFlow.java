package leetcode;

/*  https://leetcode.com/problems/pacific-atlantic-water-flow/description/  */

/*  417. Pacific Atlantic Water Flow    */

/*
*
* There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
*
* */


import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] pacific = new int[row][col];
        int[][] atlantic = new int[row][col];

        for(int i=0; i<row; i++) {
            setData(heights, Integer.MIN_VALUE, pacific, i, 0, row, col);
            setData(heights, Integer.MIN_VALUE, atlantic, i, col-1, row, col);
        }

        for(int i=0; i<col; i++) {
            setData(heights, Integer.MIN_VALUE, pacific, 0, i, row, col);
            setData(heights, Integer.MIN_VALUE, atlantic, row-1, i, row, col);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void setData(int[][] heights, int height,
                         int[][] temp, int i, int j,
                         int row, int col) {
        if(i< 0 || i >= row || j< 0 || j>= col ||
                temp[i][j] == 1 ||height > heights[i][j]) {
            return;
        }
        temp[i][j] = 1;

        setData(heights, heights[i][j], temp, i-1, j, row, col);
        setData(heights, heights[i][j], temp, i+1, j, row, col);
        setData(heights, heights[i][j], temp, i, j-1, row, col);
        setData(heights, heights[i][j], temp, i, j+1, row, col);

        return;
    }
}
