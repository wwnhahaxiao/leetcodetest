package com.roshan.leetcode;
//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//        You should preserve the original relative order of the nodes in each of the two partitions.
//        Example:
//        Input: head = 1->4->3->2->5->2, x = 3
//        Output: 1->2->2->4->3->5
public class Test0086_PartitionList {
    private static ListNode mySolution(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode originLeft = left;
        ListNode right = new ListNode(0);
        ListNode originRight = right;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = originRight.next;
        return originLeft.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5,2};
        ListNode head = new ListNode(0);
        ListNode origin = head;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = mySolution(origin.next, 3);
        System.out.println(listNode);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
