package com.roshan.leetcode;

import java.util.LinkedList;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//        A sudoku solution must satisfy all of the following rules:
//        Each of the digits 1-9 must occur exactly once in each row.
//        Each of the digits 1-9 must occur exactly once in each column.
//        Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//        Empty cells are indicated by the character '.'.
//        A sudoku puzzle...
//        ...and its solution numbers marked in red.
//        Note:
//        The given board contain only digits 1-9 and the character '.'.
//        You may assume that the given Sudoku puzzle will have a single unique solution.
//        The given board size is always 9x9.
public class Test0037_SudokuSolver {







    private static void mySolution(char[][] board) {
        //init fill up all option
        LinkedList<Character>[][] list = new LinkedList[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                list[i][j] = new LinkedList<>();
                if (board[i][j] == '.') {
                    list[i][j].add('1');
                    list[i][j].add('2');
                    list[i][j].add('3');
                    list[i][j].add('4');
                    list[i][j].add('5');
                    list[i][j].add('6');
                    list[i][j].add('7');
                    list[i][j].add('8');
                    list[i][j].add('9');
                } else {
                    list[i][j].add(board[i][j]);
                }
            }
        }
        //remove wrong option
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    removeWrong(list, i, j, board[i][j]);
                }
            }
        }
        //todo find correct option
//        for (int k = 1; k < 10; k++) {
//            int option = 0;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (list[i][j].size() == 1 && list[i][j].getFirst() == k) {
//
//                    }
//                }
//            }
//        }
        //reduce to array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (list[i][j].size() == 1) {
                    board[i][j] = list[i][j].getFirst();
                }
            }
        }
        //print
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
        System.out.println();
    }

    private static void removeWrong(LinkedList<Character>[][] list, int row, int col, char element) {
        //行内去重
        for (int c = 0; c < 9; c++) {
            if (c == col) {
                continue;
            }
            boolean remove = list[row][c].removeIf(e -> e == element);
            if (remove && list[row][c].size() == 1) {
                removeWrong(list, row, c, list[row][c].getFirst());
            }
        }
        //列内去重
        for (int r = 0; r < 9; r++) {
            if (r == row) {
                continue;
            }
            boolean remove = list[r][col].removeIf(e -> e == element);
            if (remove && list[r][col].size() == 1) {
                removeWrong(list, r, col, list[r][col].getFirst());
            }
        }
        //块内去重
        for (int b = 0; b < 3; b++) {
            for (int l = 0; l < 3; l++) {
                int rowTemp = row / 3 * 3 + b;
                int colTemp = col / 3 * 3 + l;
                if (row == rowTemp && col == colTemp) {
                    continue;
                }
                boolean remove = list[rowTemp][colTemp].removeIf(e -> e == element);
                if (remove && list[rowTemp][colTemp].size() == 1) {
                    removeWrong(list, rowTemp, colTemp, list[rowTemp][colTemp].getFirst());
                }
            }
        }
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
        mySolution(board);
    }
}
