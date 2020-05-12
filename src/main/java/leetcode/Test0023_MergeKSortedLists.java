package leetcode;

import leetcode.baseStructure.ListNode;

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//Example:
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
public class Test0023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) {
            return null;
        }
        while (size > 1) {
            for (int i = 0; i < size / 2; i++) {
                lists[i] = mergeTwoListNode(lists[i], lists[size - 1 - i]);
            }
            size = (size + 1) / 2;
        }
        return lists[0];
    }
    private static ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            }
        }
        result.next = l1 == null ? l2 : l1;
        return head.next;
    }
}

