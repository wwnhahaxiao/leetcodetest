package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;

//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//        In Pascal's triangle, each number is the sum of the two numbers directly above it.
//        Example:
//        Input: 5
//        Output:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]
public class Test0118_PascalsTriangle {
    private static List<List<Integer>> mySolution(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            first = new ArrayList<>(next(first));
            result.add(first);
        }
        return result;
    }

    private static List<Integer> next(List<Integer> list) {
        List<Integer> nextList = new ArrayList<>();
        ListIterator<Integer> iterator = list.listIterator();
        Integer temp = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            nextList.add(next + temp);
            temp = next;
        }
        nextList.add(1);
        return nextList;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = mySolution(5);
        System.out.println(lists);
    }
}
