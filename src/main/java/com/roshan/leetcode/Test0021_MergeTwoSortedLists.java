package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//        Example:
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4
public class Test0021_MergeTwoSortedLists {
    private static ListNode mySolution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            }
        }
        result.next = l1 == null ? l2 : l1;
        return head.next;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        print(listNode);
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
