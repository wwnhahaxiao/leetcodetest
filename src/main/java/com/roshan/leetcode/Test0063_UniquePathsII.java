package com.roshan.leetcode;


public class Test0063_UniquePathsII {
    private static int mySolution(int[][] obstacleGrid) {
        //判断起始位置是否为障碍物 不是把起始位置到起始位置的路径标记为1
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        //把起始位置到第一行的路径标记出来
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0;
        }
        //把起始位置到第一列的路径标记出来
        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,1}
        };
        System.out.println(mySolution(obstacleGrid));
    }
}
