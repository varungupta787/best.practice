package leetcode;

/*  200. Number of Islands  */

/*  https://leetcode.com/problems/number-of-islands/    */

/*
*
* Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*
* */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    numIslandsUtil(grid, i, j);
                }
            }
        }
        return res;
    }


    public void numIslandsUtil(char[][] grid, int row, int col) {
        if(row >= 0 && row < grid.length &&
                col >= 0 && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            numIslandsUtil(grid, row+1, col);
            numIslandsUtil(grid, row-1, col);
            numIslandsUtil(grid, row, col+1);
            numIslandsUtil(grid, row, col-1);
        }
    }
}
