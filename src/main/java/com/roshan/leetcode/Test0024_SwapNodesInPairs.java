package com.roshan.leetcode;

//Given a linked list, swap every two adjacent nodes and return its head.
//        You may not modify the values in the list's nodes, only nodes itself may be changed.
//        Example:
//        Given 1->2->3->4, you should return the list as 2->1->4->3.
public class Test0024_SwapNodesInPairs {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode mySolution(ListNode head) {
        ListNode ori = new ListNode(-1);
        ori.next = head;
        ListNode result = ori;
        while (ori.next != null && ori.next.next != null) {
            ListNode temp = ori.next;
            ListNode last = ori.next.next.next;
            ori.next = ori.next.next;
            ori.next.next = temp;
            temp.next = last;
            ori = ori.next.next;
        }
        return result.next;
    }
}
