package leetcode;

/*  130. Surrounded Regions */

/*  https://leetcode.com/problems/surrounded-regions/   */

/*
*
* Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*
* */

public class SurroundedRegions {

    public void solve(char[][] A) {
        int m = A.length;
        if(m == 0) return;
        int n = A[0].length;

        for(int i = 0; i < m; i++) {
            if(A[i][0] == 'O')
                dfs(A, i, 0);
            if(A[i][n - 1] == 'O')
                dfs(A, i, n - 1);
        }

        for(int j = 0; j < n; j++) {
            if(A[0][j] == 'O')
                dfs(A, 0, j);
            if(A[m - 1][j] == 'O')
                dfs(A, m - 1, j);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 'O')
                    A[i][j] = 'X';
                if(A[i][j] == 'P')
                    A[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] A, int x, int y) {
        if(x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] == 'O') {
            A[x][y] = 'P';
            dfs(A, x + 1, y);
            dfs(A, x, y + 1);
            dfs(A, x - 1, y);
            dfs(A, x, y - 1);
        } else return;
    }
}
