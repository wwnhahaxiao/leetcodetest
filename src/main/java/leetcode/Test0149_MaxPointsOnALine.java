package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//        Example 1:
//        Input: [[1,1],[2,2],[3,3]]
//        Output: 3
//        Explanation:
//        ^
//        |
//        |        o
//        |     o
//        |  o  
//        +------------->
//        0  1  2  3  4
//        Example 2:
//        Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//        Output: 4
//        Explanation:
//        ^
//        |
//        |  o
//        |     o        o
//        |        o
//        |  o        o
//        +------------------->
//        0  1  2  3  4  5  6
//        NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
public class Test0149_MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> lineMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                String slope = getSlope(a, b);
                String intersection = getIntersection(a, slope);
                String key = slope + "-" + intersection;
                Integer pointNum = lineMap.getOrDefault(key, 1);
                lineMap.put(key, ++pointNum);
            }
//            max = Math.max(.get(), max);
        }
        return max;
    }

    private String getSlope(int[] a, int[] b) {
        return "";
    }

    private String getIntersection(int[] a, String slope) {
        return "";
    }
}
