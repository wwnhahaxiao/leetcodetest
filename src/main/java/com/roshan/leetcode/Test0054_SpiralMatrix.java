package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//        Example 1:
//        Input:
//        [
//        [ 1, 2, 3 ],
//        [ 4, 5, 6 ],
//        [ 7, 8, 9 ]
//        ]
//        Output: [1,2,3,6,9,8,7,4,5]
//        Example 2:
//        Input:
//        [
//        [1, 2, 3, 4],
//        [5, 6, 7, 8],
//        [9,10,11,12]
//        ]
//        Output: [1,2,3,4,8,12,11,10,9,5,6,7]
public class Test0054_SpiralMatrix {
    public static List<Integer> mySolution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int down = 0, up = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (left <= right && down <= up) {
            //添加最下面一条线
            for (int i = left; i <= right; i++) {
                result.add(matrix[down][i]);
            }
            down++;
            //添加最右面一条线
            for (int i = down; i <= up; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            //添加最上面一条线
            for (int i = right; i >= left && down <= up; i--) {
                result.add(matrix[up][i]);
            }
            up--;
            //添加最左面一条线
            for (int i = up; i >= down && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,5},{8,4},{0,-1}};
        List<Integer> integers = mySolution(matrix);
        System.out.println(integers);
    }
}
