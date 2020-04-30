package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*994. Rotting Oranges*/

/*https://leetcode.com/problems/rotting-oranges/*/

/*
* In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
* */


public class RottingOranges {

    class Orange {
        int type;
        int x;
        int y;
        int cost;

        Orange(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int time = 0;
        boolean isFresh = false;
        Queue<Orange> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    isFresh = true;
                }

                if (grid[i][j] == 2) {
                    Orange org = new Orange(i, j, 2);
                    queue.add(org);
                }
            }
        }

        if (!isFresh)
            return 0;

        int size = 0;
        while (queue.size() > 0) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Orange curr = queue.poll();
                int x = curr.x;
                int y = curr.y;
                int cost = curr.cost;
                time = cost;

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    Orange newOrg = new Orange(x - 1, y, 2);
                    newOrg.cost = cost + 1;
                    queue.add(newOrg);
                    grid[x - 1][y] = 2;
                }

                if (x + 1 < row && grid[x + 1][y] == 1) {
                    Orange newOrg = new Orange(x + 1, y, 2);
                    newOrg.cost = cost + 1;
                    queue.add(newOrg);
                    grid[x + 1][y] = 2;
                }

                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    Orange newOrg = new Orange(x, y - 1, 2);
                    newOrg.cost = cost + 1;
                    queue.add(newOrg);
                    grid[x][y - 1] = 2;
                }

                if (y + 1 < col && grid[x][y + 1] == 1) {
                    Orange newOrg = new Orange(x, y + 1, 2);
                    newOrg.cost = cost + 1;
                    queue.add(newOrg);
                    grid[x][y + 1] = 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    time = -1;
                    break;
                }
            }
        }
        return time;
    }
}