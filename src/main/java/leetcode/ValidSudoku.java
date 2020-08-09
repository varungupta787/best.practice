package leetcode;

/*  36. Valid Sudoku    */

/*  https://leetcode.com/problems/valid-sudoku/ */

/*
*
* Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
*
* */

public class ValidSudoku {
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

    public boolean isValidSudoku(char[][] a) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(a[i][j] == '.')
                    continue;

                char ch = a[i][j];
                a[i][j] = '.';

                if(isExists(a, ch, i, j))
                    return false;

                a[i][j] = ch;
            }
        }

        return true;
    }
}
