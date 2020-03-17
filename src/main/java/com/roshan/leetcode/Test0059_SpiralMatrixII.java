package com.roshan.leetcode;
//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//        Example:
//        Input: 3
//        Output:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]
public class Test0059_SpiralMatrixII {
    private static int[][] mySolution(int n) {
        int[][] result = new int[n][n];
        int down = 0, up = n - 1, left = 0, right = n - 1;
        int value = 1;
        while (value <= n * n) {
            for (int i = left; i <= right; i++) {
                result[down][i] = value++;
            }
            if (value > n * n) {
                return result;
            }
            down++;
            for (int i = down; i <= up; i++) {
                result[i][right] = value++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[up][i] = value++;
            }
            if (value > n * n) {
                return result;
            }
            up--;
            for (int i = up; i >= down; i--) {
                result[i][left] = value++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = mySolution(5);
        System.out.println(ints);
    }
}
