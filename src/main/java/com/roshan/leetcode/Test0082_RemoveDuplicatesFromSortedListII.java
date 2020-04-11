package com.roshan.leetcode;
//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//        Return the linked list sorted as well.
//        Example 1:
//        Input: 1->2->3->3->4->4->5
//        Output: 1->2->5
//        Example 2:
//        Input: 1->1->1->2->3
//        Output: 2->3
public class Test0082_RemoveDuplicatesFromSortedListII {
    public static ListNode mySolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = new ListNode(0);
        ListNode result = curr;
        ListNode prev = head;
        while (head.next != null) {
            head = head.next;
            if (prev.val == head.val) {
                while (head != null && head.val == prev.val) {
                    head = head.next;
                }
                if (head == null) {
                    break;
                }
            } else {
                curr.next = prev;
                curr = curr.next;
            }
            prev = head;
        }
        curr.next = head;
        return result.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,4,5,5};
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
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
