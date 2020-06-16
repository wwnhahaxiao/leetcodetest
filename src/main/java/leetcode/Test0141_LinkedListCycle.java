package leetcode;

import leetcode.baseStructure.ListNode;

public class Test0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {
            two = two.next.next;
            one = one.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }
}
