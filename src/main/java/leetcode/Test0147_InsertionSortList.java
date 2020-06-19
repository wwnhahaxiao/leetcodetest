package leetcode;

import leetcode.baseStructure.ListNode;
import org.junit.Test;

//Sort a linked list using insertion sort.
//        A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
//        With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
//        Algorithm of Insertion Sort:
//        Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
//        At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
//        It repeats until no input elements remain.
//        Example 1:
//        Input: 4->2->1->3
//        Output: 1->2->3->4
//        Example 2:
//        Input: -1->5->3->4->0
//        Output: -1->0->3->4->5
public class Test0147_InsertionSortList {
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode next = curr.next;

            if (curr.val < pre.val) {
                pre.next = null;
                curr.next = null;
                correct(dummy, curr);
            }
            pre = curr;
            curr = next;
        }
    }
    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        dummy.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {// 本来就有序
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                // 找到一个位置使得p < cur < p.next
                while (p.next != cur && p.next.val < cur.val) {
                    p = p.next;
                }
                // 将cur插入到p和p.next之间
                // 因为cur被插到前面，pre的指针需要跳过cur
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                // 完成插入后，cur回到pre后面
                cur = pre.next;
            }
        }
        return dummy.next;
    }

    private ListNode insertionSortList(ListNode head) {
        ListNode correct = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            correct(correct, head);
            head = next;
        }
        return correct.next;
    }

    private void correct(ListNode head, ListNode node) {
        ListNode pre = null;
        while (head != null) {
            if (head.val > node.val) {
                pre.next = node;
                node.next = head;
                return;
            }
            pre = head;
            head = head.next;
        }
        pre.next = node;
    }

    @Test
    public void test() {
        ListNode head = ListNode.build(4,2,1,3);
        ListNode listNode = insertionSortList(head);
        System.out.println(listNode);
    }
}
