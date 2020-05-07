package com.roshan.leetcode;

import org.junit.Test;

import java.util.*;

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

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currRow = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> nextRow = new LinkedList<>();
            Integer pre = 0;
            ListIterator<Integer> iterator = currRow.listIterator();
            while (iterator.hasNext()) {
                Integer curr = iterator.next();
                nextRow.add(pre + curr);
                pre = curr;
            }
            nextRow.add(1);
            result.add(nextRow);
            currRow = nextRow;
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
}
