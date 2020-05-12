package leetcode;

import java.util.Arrays;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//        Example 1:
//        Input:
//        [
//          [1,1,1],
//          [1,0,1],
//          [1,1,1]
//        ]
//        Output:
//        [
//          [1,0,1],
//          [0,0,0],
//          [1,0,1]
//        ]
//        Example 2:
//        Input:
//        [
//          [0,1,2,0],
//          [3,4,5,2],
//          [1,3,1,5]
//        ]
//        Output:
//        [
//          [0,0,0,0],
//          [0,4,5,0],
//          [0,3,1,0]
//        ]
//        Follow up:
//        A straight forward solution using O(mn) space is probably a bad idea.
//        A simple improvement uses O(m + n) space, but still not the best solution.
//        Could you devise a constant space solution?
public class Test0073_SetMatrixZeroes {
    private static void mySolution(int[][] matrix) {
        boolean lastRowContainZ = false;
        for (int i = 0; i < matrix.length; i++) {
            boolean thisRowContainZ = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    thisRowContainZ = true;
                    for (int k = 0; k < i; k++) {
                        matrix[k][j] = 0;
                    }
                }
                if (i > 0 && matrix[i - 1][j] == 0) {
                    matrix[i][j] = 0;
                }
                if (j == matrix[0].length - 1 && lastRowContainZ) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i - 1][k] = 0;
                    }
                }
            }
            lastRowContainZ = thisRowContainZ;
        }
        if (lastRowContainZ) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[matrix.length - 1][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        mySolution(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
