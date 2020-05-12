package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = mySolution(matrix);
        System.out.println(integers);
    }
    private static List<Integer> mySolution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int down = 0, up = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (left <= right && down <= up) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[down][i]);
            }
            down++;
            for (int i = down; i <= up; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && down <= up; i--) {
                result.add(matrix[up][i]);
            }
            up--;
            for (int i = up; i >= down && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
    /*
    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表移除
        路径.add(选择)
        backtrack(路径, 选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择再加入选择列表
     */
}
