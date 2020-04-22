package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;

//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//        Example 1:
//        Input: 1->2->3->4->5->NULL, k = 2
//        Output: 4->5->1->2->3->NULL
//        Explanation:
//        rotate 1 steps to the right: 5->1->2->3->4->NULL
//        rotate 2 steps to the right: 4->5->1->2->3->NULL
//        Example 2:
//        Input: 0->1->2->NULL, k = 4
//        Output: 2->0->1->NULL
//        Explanation:
//        rotate 1 steps to the right: 2->0->1->NULL
//        rotate 2 steps to the right: 1->2->0->NULL
//        rotate 3 steps to the right: 0->1->2->NULL
//        rotate 4 steps to the right: 2->0->1->NULL
public class Test0061_RotateList {
    private static ListNode mySolution(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        //计算链表长度length
        int length = 1;
        ListNode ori = head;
        while (head.next != null) {
            head = head.next;
            length++;
        }
        //尾指向头造成循环
        head.next = ori;
        //从头数length - (k % length) - 1个就是新表的尾部:ori
        for (int i = 0; i < length - (k % length) - 1; i++) {
            ori = ori.next;
        }
        head = ori.next;
        ori.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode origin = new ListNode(0);
        ListNode head = origin;
        for (int i = 1; i < 3; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = mySolution(origin, 4);
        System.out.println(listNode);
    }

}
