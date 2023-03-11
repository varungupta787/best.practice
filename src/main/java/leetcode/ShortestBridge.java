package leetcode;

/*  https://leetcode.com/problems/shortest-bridge/description/  */

/*  934. Shortest Bridge    */

/*
*
* You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.



Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1


Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
*
* */


import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>()  ;

        boolean marked =false;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    markOneIsland(grid, i, j, q);
                    marked = true;
                }
                if(marked) {
                    break;
                }
            }
            if(marked) {
                break;
            }
        }


        int[][] dir = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] lastLocation = q.poll();
                int i = lastLocation[0];
                int j = lastLocation[1];
                int x = 0;
                int y = 0;
                for(int[] arr : dir) {
                    x = i+arr[0];
                    y = j+arr[1];
                    if(x >= 0 && x< grid.length &&
                            y >= 0 &&  y<grid[x].length &&
                            grid[x][y] != -1) {
                        if(grid[x][y] == 1) {
                            return result;
                        }
                        grid[x][y] = -1;
                        q.offer(new int[] {x,y});
                    }
                }
            }
            result++;
        }

        return result;
    }



    private void markOneIsland(int[][] grid, int i, int j,
                               Queue<int[]> q) {
        if(i>= 0 && i< grid.length && j>= 0 &&
                j<grid[i].length && grid[i][j] == 1) {
            grid[i][j] = -1;
            q.offer(new int[]{i, j});
            markOneIsland(grid, i+1, j, q);
            markOneIsland(grid, i-1, j, q);
            markOneIsland(grid, i, j+1, q);
            markOneIsland(grid, i, j-1, q);
        }
    }


}
