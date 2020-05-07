package com.roshan.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//        Note that the row index starts from 0.
//        In Pascal's triangle, each number is the sum of the two numbers directly above it.
//        Example:
//        Input: 3
//        Output: [1,3,3,1]
//        Follow up:
//        Could you optimize your algorithm to use only O(k) extra space?
public class Test0119_PascalsTriangleII {
    private List<Integer> getRow2(int rowIndex) {
        LinkedList<Integer> row = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            int temp = 0;
            for (int j = 0; j < row.size(); j++) {
                Integer pre = row.removeFirst();
                row.add(pre + temp);
                temp = pre;
            }
            row.add(1);
        }
        return row;
    }

    private List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> row = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            int pre = 0;
            for (int j = 0; j < row.size(); j++) {
                Integer curr = row.removeFirst();
                row.add(curr + pre);
                pre = curr;
            }
            row.add(1);
        }
        return row;
    }

    @Test
    public void test() {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
