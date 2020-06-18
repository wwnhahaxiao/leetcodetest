package leetcode;

import leetcode.baseStructure.ListNode;
import org.junit.Test;

import java.util.LinkedList;

//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//        You may not modify the values in the list's nodes, only nodes itself may be changed.
//        Example 1:
//        Given 1->2->3->4, reorder it to 1->4->2->3.
//        Example 2:
//        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
public class Test0143_ReorderList {
    private void reorderList(ListNode head) {
        if (head == null) return;
        //找到中点slow
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        //倒序后半段
        tail = reverse(tail);
        //重新排序
        while (tail != null) {
            ListNode temp = tail.next;
            tail.next = head.next;
            head.next = tail;
            head = tail.next;
            tail = temp;
        }
    }
    private ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        reorderList(l1);
        System.out.println(l1);
    }

}
