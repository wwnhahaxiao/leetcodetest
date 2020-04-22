package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//        Example 1:
//        Input: 1->1->2
//        Output: 1->2
//        Example 2:
//        Input: 1->1->2->3->3
//        Output: 1->2->3
public class Test0083_RemoveDuplicatesFromSortedList {
    private static ListNode mySolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode origin = head;
        ListNode last = head;
        while (head.next != null) {
            head = head.next;
            if (head.val == last.val) {
                last.next = head.next;
            } else {
                last = head;
            }
        }
        return origin;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5,};
        ListNode head = new ListNode(0);
        ListNode origin = head;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = mySolution(origin.next);
        System.out.println(listNode);
    }
}

