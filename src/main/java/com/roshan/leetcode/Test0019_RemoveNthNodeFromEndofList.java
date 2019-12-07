package com.roshan.leetcode;

//Given a linked list, remove the n-th node from the end of list and return its head.
//        Example:
//        Given linked list: 1->2->3->4->5, and n = 2.
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//        Given n will always be valid.
//        Follow up:
//        Could you do this in one pass?
public class Test0019_RemoveNthNodeFromEndofList {
    /**
     * Definition for singly-linked head.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    private static ListNode mySolution(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode last = head;
        int len = 1;
        for (int i = 1; i < n; i++) {
            last = last.next;
            len++;
        }
        while (last.next != null) {
            first = first.next;
            last = last.next;
            len++;
        }
        if (len == n) {
            return head.next;
        }
        first.next = first.next.next;
        return head;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = mySolution(listNode, 1);
        print(listNode1);
    }

    private static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }
        System.out.print(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.print(" -> " + listNode.val);
        }
        System.out.println();
    }
}
