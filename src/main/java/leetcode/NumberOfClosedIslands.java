package leetcode;

/*  https://leetcode.com/problems/number-of-closed-islands/ */

/*  1254. Number of Closed Islands  */

/*
*
* Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.



Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
*
* */



public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    if(isCloseIsland(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public boolean isCloseIsland(int[][]grid, int i, int j) {
        if(i< 0 || i>= grid.length || j<0 || j>=grid[0].length) {
            return false;
        }
        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;
        boolean left = isCloseIsland(grid, i, j - 1);
        boolean right = isCloseIsland(grid, i, j + 1);
        boolean top = isCloseIsland(grid, i - 1, j);
        boolean down = isCloseIsland(grid, i + 1, j);
        boolean res = left && right && top && down;
        return res;
    }
}
