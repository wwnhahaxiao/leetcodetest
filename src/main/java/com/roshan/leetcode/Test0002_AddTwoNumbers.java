package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;

import java.util.LinkedList;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//        Example:
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
public class Test0002_AddTwoNumbers {
    public static ListNode mySolution(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val, b = l2 == null ? 0 : l2.val;
            int value = a + b + extra;
            if (value > 9) {
                extra = 1;
                value -= 10;
            } else {
                extra = 0;
            }
            curr.next = new ListNode(value);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (extra == 1)  {
            curr.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        ListNode result = mySolution(a, b);
        System.out.println(result);
    }
}
