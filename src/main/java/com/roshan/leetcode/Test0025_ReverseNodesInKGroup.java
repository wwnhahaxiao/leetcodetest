package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;

import java.util.LinkedList;
import java.util.List;

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//        k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//        Example:
//        Given this linked list: 1->2->3->4->5
//        For k = 2, you should return: 2->1->4->3->5
//        For k = 3, you should return: 3->2->1->4->5
//        Note:
//        Only constant extra memory is allowed.
//        You may not alter the values in the list's nodes, only nodes itself may be changed.
public class Test0025_ReverseNodesInKGroup {
    private static ListNode mySolution(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        ListNode ori = result;
        ListNode[] temp = new ListNode[k];
        int i = 0;
        while (head != null) {
            temp[i] = head;
            head = head.next;
            if (i == k - 1) {
                while (i >= 0) {
                    result.next = temp[i];
                    temp[i] = null;
                    result = result.next;
                    i--;
                }
            }
            i++;
        }
        for (ListNode node : temp) {
            if (node != null) {
                result.next = node;
                result = result.next;
            }
        }
        return ori.next;
    }

    private static ListNode mySolution2(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode ori = pre;
        ListNode end = pre;
        int i = 0;
        while (end.next != null) {
            end = end.next;
            i++;
            if (i == k) {
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(head);
                end = new ListNode(0);
                end.next = next;
                while (pre.next != null) pre = pre.next;
                i = 0;
                head = end.next;
            }
        }
        pre.next = head;
        return ori.next;
    }
    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        long l = System.currentTimeMillis();
        ListNode node = mySolution2(head, 4);
        System.out.println(System.currentTimeMillis() - l);
        node.print();
    }
}
