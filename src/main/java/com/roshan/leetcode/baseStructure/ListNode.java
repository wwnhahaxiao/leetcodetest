package com.roshan.leetcode.baseStructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        System.out.print(val);
        ListNode nextNode = next;
        while (nextNode != null) {
            System.out.print(" -> " + nextNode.val);
            nextNode = nextNode.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
