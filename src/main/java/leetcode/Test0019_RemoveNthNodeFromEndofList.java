package leetcode;

import leetcode.baseStructure.ListNode;

//Given a linked list, remove the n-th node from the end of list and return its head.
//        Example:
//        Given linked list: 1->2->3->4->5, and n = 2.
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//        Given n will always be valid.
//        Follow up:
//        Could you do this in one pass?
public class Test0019_RemoveNthNodeFromEndofList {
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

    public static void main(String[] args) {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        ListNode listNode = mySolution(head, 1);
        listNode.print();
    }
}
