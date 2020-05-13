package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//        You may assume that the intervals were initially sorted according to their start times.
//        Example 1:
//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]
//        Example 2:
//        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
//        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//        NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
public class Test0057_InsertInterval {
    private static int[][] mySolution(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            if ((arr[0] <= newInterval[0] && arr[1] >= newInterval[0])
                    || (arr[0] <= newInterval[1] && arr[1] >= newInterval[1])
                    || (arr[0] <= newInterval[0] && arr[1] >= newInterval[1])
                    || (arr[0] >= newInterval[0] && arr[1] <= newInterval[1])) {
                newInterval[0] = Math.min(newInterval[0], arr[0]);
                newInterval[1] = Math.max(newInterval[1], arr[1]);
            } else {
                list.add(arr);
            }
        }
        list.add(newInterval);
        list.sort(Comparator.comparingInt(arr -> arr[0]));
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(mySolution(intervals, newInterval)));
    }
}