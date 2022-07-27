package leetcode;

/*  51. N-Queens    */

/*  https://leetcode.com/problems/n-queens/ */

/*
*
* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.



Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
*
* */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result = null;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] arr = new char[n][n];
        reset(arr, n);
        solveNQueensUtil(n, arr, 0);
        return result;
    }


    public void solveNQueensUtil(int n, char[][] arr, int row) {
        if(row == n) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                StringBuffer sb = new StringBuffer();
                for(char ch : arr[i]) {
                    sb.append(ch);
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for(int j=0; j<n; j++) {
            if(colCheck(row, j, arr) &&
                    diagonalCheck(row, j, arr)) {
                arr[row][j] = 'Q';
                solveNQueensUtil(n, arr, row+1);
            }
            arr[row][j] = '.';
        }
    }

    private boolean colCheck(int row, int col, char[][] arr) {
        for(int i=0; i<row; i++) {
            if(arr[i][col] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private boolean diagonalCheck(int row, int col, char[][] arr) {
        int i = row, j = col, n = arr.length;

        while(i>=0 && j>= 0) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row-1;
        j = col+1;
        while(i>=0 && j < n) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    private void reset(char[][] arr, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = '.';
            }
        }
    }
}
