package leetcode;

import leetcode.baseStructure.ListNode;
import org.junit.Test;

//Reverse a singly linked list.
//        Example:
//        Input: 1->2->3->4->5->NULL
//        Output: 5->4->3->2->1->NULL
//        Follow up:
//        A linked list can be reversed either iteratively or recursively. Could you implement both?
public class Test0206_ReverseLinkedList {
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        ListNode listNode = reverseList(head);
        listNode.print();
    }
}
