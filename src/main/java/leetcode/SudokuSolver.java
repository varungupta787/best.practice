package leetcode;

/*  37. Sudoku Solver   */

/*  https://leetcode.com/problems/sudoku-solver/    */

/*
*
* Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
*
* */

public class SudokuSolver {

    Indices indices = new Indices(0 , 0);
    class Indices{
        int x, y;
        Indices(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void findEmptyIndices(char[][] a){

        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(a[i][j] == '.')
                {
                    indices.x = i;
                    indices.y = j;
                    return;
                }
        indices.x = -1;
    }
    public boolean isExists(char[][] a, char ch, int i, int j){

        for(int m = 0; m < 9; m++)
            if(a[m][j] == ch || a[i][m] == ch)
                return true;
        i = (i / 3) * 3;
        j = (j / 3) * 3;
        for(int m = i; m < i + 3; m++)
            for(int n = j; n < j + 3; n++)
                if(a[m][n] == ch)
                    return true;
        return false;
    }

    public boolean solveSudoku(char[][] a) {

        findEmptyIndices(a);
        if(indices.x == -1)
            return true;
        int i = indices.x;
        int j = indices.y;
        for(char m = '1'; m <= '9'; m++){
            boolean exist = isExists(a, m, i, j);
            if(!exist){
                a[i][j] = m;
                boolean valid = solveSudoku(a);
                if(valid)
                    return true;
                a[i][j] = '.';
            }
        }
        return false;
    }
}
