package com.roshan.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//        Given an integer n, return all distinct solutions to the n-queens puzzle.
//        Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//        Example:
//        Input: 4
//        Output: [
//        [".Q..",  // Solution 1
//        "...Q",
//        "Q...",
//        "..Q."],
//        ["..Q.",  // Solution 2
//        "Q...",
//        "...Q",
//        ".Q.."]
//        ]
//        Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
public class Test0051_NQueens {
    private static int boardSize = 0;
    private static char[][] board = null;
    private static int[] rows = null;
    private static int[] cols = null;
    private static int[] leftSlash = null;
    private static int[] rightSlash = null;
    private static int count = 0;
    private static List<List<String>> result = null;

    private static List<List<String>> mySolution(int n) {
        init(n);
        backtrack(0, 0);
        return result;
    }

    private static void backtrack(int row, int col) {
        boolean placed = false;
        if (couldPlace(row, col)) {
            for (int i = 0; i < 2; i++) {
                placed = true;
                placeQueen(row, col, i == 0 ? 'Q' : '.');
                placeNextQueen(row, col);
                removeQueen(row, col);
            }
        }
        if (!placed) {
            placeNextQueen(row, col);
        }
    }

    private static void placeNextQueen(int row, int col) {
        if (row == boardSize - 1 && col == boardSize - 1) {
            if (count == boardSize) {
                addSolution();
            }
        } else {
            if (col == boardSize - 1) {
                backtrack(++row, 0);
            } else {
                backtrack(row, ++col);
            }
        }
    }

    private static void placeQueen(int row, int col, char value) {
        if (value == 'Q') {
            rows[row] = 1;
            cols[col] = 1;
            leftSlash[boardSize - 1 - row + col] = 1;
            rightSlash[row + col] = 1;
            board[row][col] = value;
            count++;
        }
    }

    private static void removeQueen(int row, int col) {
        if (board[row][col] == 'Q') {
            rows[row] = 0;
            cols[col] = 0;
            leftSlash[boardSize - 1 - row + col] = 0;
            rightSlash[row + col] = 0;
            board[row][col] = '.';
            count--;
        }
    }

    private static boolean couldPlace(int row, int col) {
        return rows[row] + cols[col]+ leftSlash[boardSize - 1 - row + col] + rightSlash[row + col] == 0;
    }

    private static void init(int size) {
        result = new ArrayList<>();
        boardSize = size;
        board = new char[size][size];
        rows = new int[size];
        cols = new int[size];
        leftSlash = new int[size * 2 - 1];
        rightSlash = new int[size * 2 - 1];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
    }

    private static void addSolution() {
        List<String> list = new ArrayList<>();
        for (char[] line : board) {
            list.add(new String(line));
        }
        result.add(list);
    }

    public static void main(String[] args) {
        List<List<String>> lists = mySolution(4);
    }
}
