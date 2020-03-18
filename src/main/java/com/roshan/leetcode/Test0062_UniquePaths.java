package com.roshan.leetcode;

import java.util.Arrays;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//        How many possible unique paths are there?
//        Above is a 7 x 3 grid. How many possible unique paths are there?
//        Example 1:
//        Input: m = 3, n = 2
//        Output: 3
//        Explanation:
//        From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//        1. Right -> Right -> Down
//        2. Right -> Down -> Right
//        3. Down -> Right -> Right
//        Example 2:
//        Input: m = 7, n = 3
//        Output: 28
//        Constraints:
//        1 <= m, n <= 100
//        It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
public class Test0062_UniquePaths {
    private static int mySolution(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return mySolution(m - 1, n) + mySolution(m, n - 1);
        }
    }
    private static int mySolution2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(mySolution2(51, 9));
    }


}
