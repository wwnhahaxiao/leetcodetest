package com.roshan.leetcode;

import java.util.Arrays;

//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//        Example:
//        Input:
//        [
//        ["1","0","1","0","0"],
//        ["1","0","1","1","1"],
//        ["1","1","1","1","1"],
//        ["1","0","0","1","0"]
//        ]
//        Output: 6
public class Test0085_MaximalRectangle {

    private static int mySolution(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n - 1);

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int leftMax = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(leftMax, left[j]);
                } else {
                    leftMax = j + 1;
                    left[j] = 0;
                }
            }
            int rightMax = n - 1;
            for (int j = n - 1; j >=0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(rightMax, right[j]);
                } else {
                    rightMax = j - 1;
                    right[j] = n - 1;
                }
            }
            for (int j = 0; j < n; j++) {
                if ((right[j] - left[j] + 1) * height[j] == 8) {
                    System.out.println();
                }
                maxArea = Math.max((right[j] - left[j] + 1) * height[j], maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int i = mySolution(matrix);
        System.out.println(i);
    }
}
