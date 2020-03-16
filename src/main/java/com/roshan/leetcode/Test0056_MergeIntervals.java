package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given a collection of intervals, merge all overlapping intervals.
//        Example 1:
//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//        Example 2:
//        Input: [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//        NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
public class Test0056_MergeIntervals {
    private static int[][] mySolution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] source : intervals) {
            boolean insert = false;
            for (int[] target : list) {
                if ((source[0] <= target[0] && source[1] >= target[0])
                        || (source[0] <= target[1] && source[1] >= target[1])
                        || (source[0] <= target[0] && source[1] >= target[1])
                        || (source[0] >= target[0] && source[1] <= target[1])) {
                    target[0] = Math.min(target[0], source[0]);
                    target[1] = Math.max(target[1], source[1]);
                    insert = true;
                    break;
                }
            }
            if (!insert) {
                list.add(source);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,4},{4,5}};
//        int[][] intervals = {{1,4},{1,4}};
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(mySolution(intervals)));
    }
}
