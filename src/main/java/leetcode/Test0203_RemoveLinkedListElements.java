package leetcode;

import leetcode.baseStructure.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Remove all elements from a linked list of integers that have value val.
//        Example:
//        Input:  1->2->6->3->4->5->6, val = 6
//        Output: 1->2->3->4->5
public class Test0203_RemoveLinkedListElements {
    private ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        ListNode origin = pre;
        pre.next = head;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return origin.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.build(6, 2, 6, 3, 4, 5, 6);
        ListNode listNode = removeElements(head, 6);
        System.out.println(listNode);
    }
}
