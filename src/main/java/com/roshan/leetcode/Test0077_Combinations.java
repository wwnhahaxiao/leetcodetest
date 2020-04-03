package com.roshan.leetcode;

import java.util.*;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//        Example:
//        Input: n = 4, k = 2
//        Output:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
public class Test0077_Combinations {

    private static List<List<Integer>> result;
    private static Integer limit;

    private static List<List<Integer>> mySolution(int n, int k) {
        result = new ArrayList<>();
        limit = n;
        int[] ints = new int[k];
        placeIndex(ints, 0, 1);
        return result;
    }
    private static void placeIndex(int[] ints, int index, int first) {
        if (index == ints.length) {
            return;
        }
        for (int i = first; i <= limit; i++) {
            if (index == 0 || i > ints[index - 1]) {
                ints[index] = i;
                if (index == ints.length - 1) {
                    List<Integer> list = new ArrayList<>();
                    for (int n : ints) {
                        list.add(n);
                    }
                    result.add(list);
                }
                placeIndex(ints, index + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = mySolution(4, 2);
        System.out.println(lists);
    }
}
