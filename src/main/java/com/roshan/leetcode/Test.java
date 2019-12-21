package com.roshan.leetcode;

import java.util.HashSet;

public class Test {
    // box size
    static int n = 3;
    // row size
    static int N = n * n;

    static int [][] rows = new int[N][N + 1];
    static int [][] columns = new int[N][N + 1];
    static int [][] boxes = new int[N][N + 1];

    static char[][] board;

    static boolean sudokuSolved = false;

    public static boolean couldPlace(int d, int row, int col) {
    /*
    Check if one could place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public static void placeNumber(int d, int row, int col) {
    /*
    Place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        //int + '0' = (char)int
        board[row][col] = (char)(d + '0');
    }

    public static void removeNumber(int d, int row, int col) {
    /*
    Remove a number which didn't lead to a solution
    */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public static void placeNextNumbers(int row, int col) {
    /*
    Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public static void backtrack(int row, int col) {
    /*
    Backtracking
    */
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                    }
                }
            }
        }
        else placeNextNumbers(row, col);
    }

    public static void solveSudoku(char[][] board) {
        Test.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','9',  '7','4','8',  '.','.','.'},
                {'7','.','.',  '.','.','.',  '.','.','.'},
                {'.','2','.',  '1','.','9',  '.','.','.'},

                {'.','.','7',  '.','.','.',  '2','4','.'},
                {'.','6','4',  '.','1','.',  '5','9','.'},
                {'.','9','8',  '.','.','.',  '3','.','.'},

                {'.','.','.',  '8','.','3',  '.','2','.'},
                {'.','.','.',  '.','.','.',  '.','.','6'},
                {'.','.','.',  '2','7','5',  '9','.','.'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if (j % 3 == 2) {
                    System.out.print("  ");
                }
            }
            if (i % 3 == 2) {
                System.out.println();
            }
            System.out.println();
        }
    }
}
