package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//        For example, given the following triangle
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//        Note:
//        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
public class Test0120_Triangle {
    private int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }

    @Test
    public void test() {
        List<List<Integer>> triangle = build(2, null, 3, 4, null, 6, 5, 7, null, 4, 1, 8, 3, null);
        int step = minimumTotal(triangle);
        System.out.println(step);
    }

    private List<List<Integer>> build(Integer... values) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        for (Integer v : values) {
            if (v == null) {
                result.add(row);
                row = new ArrayList<>();
            } else {
                row.add(v);
            }
        }
        return result;
    }
}
