package com.roshan.leetcode;

import java.util.LinkedList;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//        Example:
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
public class Test0002_AddTwoNumbers {
    private static LinkedList mySolution(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int length = l1.size() > l2.size() ? l1.size() : l2.size();
        LinkedList<Integer> ret = new LinkedList<>();
        int extend = 0;
        for (int i = 0; i < length; i++) {
            int a = 0;
            int b = 0;
            if (l1.size() >= i) {
                a = l1.get(i);
            }
            if (l2.size() >= i) {
                b = l2.get(i);
            }
            int sum = a + b;
            sum += extend;
            extend = sum / 10;
            ret.add(sum % 10);
        }
        if (extend > 0) {
            ret.add(extend);
        }
        return ret;
    }

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        a.add(0);
        a.add(0);
        a.add(5);
        LinkedList<Integer> b = new LinkedList<>();
        b.add(0);
        b.add(0);
        b.add(5);
        LinkedList<Integer> linkedList = mySolution(a, b);
        for (Integer n : linkedList) {
            System.out.println(n);
        }
    }
}
