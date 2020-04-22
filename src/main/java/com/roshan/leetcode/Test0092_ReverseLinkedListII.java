package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;

//Reverse a linked list from position m to n. Do it in one-pass.
//        Note: 1 ≤ m ≤ n ≤ length of list.
//        Example:
//        Input: 1->2->3->4->5->NULL, m = 2, n = 4
//        Output: 1->4->3->2->5->NULL
public class Test0092_ReverseLinkedListII {
    private static ListNode mySolution(ListNode head, int m, int n) {
        ListNode origin = new ListNode(1);
        origin.next = head;
        head = origin;
        m++;
        n++;
        int index = 1;
        ListNode pre = null;
        ListNode reversePre = null;
        while (head != null) {
            if (index == m - 1) {
                reversePre = head;
            }
            if (index >= m && index <= n) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                if (index == n) {
                    reversePre.next.next = next;
                    reversePre.next = head;
                }
                head = next;
            } else {
                pre = head;
                head = head.next;
            }
            index++;
        }
        return origin.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(0);
        ListNode origin = head;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = mySolution(origin.next, 1, 5);
        System.out.println(listNode);
    }
}
