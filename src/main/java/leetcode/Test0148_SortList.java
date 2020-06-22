package leetcode;

import leetcode.baseStructure.ListNode;
import org.junit.Test;

//Sort a linked list in O(n log n) time using constant space complexity.
//        Example 1:
//        Input: 4->2->1->3
//        Output: 1->2->3->4
//        Example 2:
//        Input: -1->5->3->4->0
//        Output: -1->0->3->4->5
public class Test0148_SortList {
    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //分割head为head和right
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        //将head和right排序
        head = sortList(head);
        right = sortList(right);
        //按顺序合并head和right
        return merge(head, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return head.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.build(4,2,1,3);
//        ListNode head = ListNode.build(4,19,14,5,-3,1,8,5,11,15);
        ListNode listNode = sortList(head);
        System.out.println(listNode);
    }
}
