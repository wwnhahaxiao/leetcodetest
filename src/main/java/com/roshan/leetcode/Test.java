package com.roshan.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ListIterator<Integer> iterator = list.listIterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());
        System.out.println(iterator.previous());
    }
}
