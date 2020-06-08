package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//        Return a deep copy of the list.
//        The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//        val: an integer representing Node.val
//        random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
//        Example 1:
//        Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//        Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//        Example 2:
//        Input: head = [[1,1],[2,1]]
//        Output: [[1,1],[2,1]]
//        Example 3:
//        Input: head = [[3,null],[3,0],[3,null]]
//        Output: [[3,null],[3,0],[3,null]]
//        Example 4:
//        Input: head = []
//        Output: []
//        Explanation: Given linked list is empty (null pointer), so return null.
//        Constraints:
//        -10000 <= Node.val <= 10000
//        Node.random is null or pointing to a node in the linked list.
//        Number of Nodes will not exceed 1000.
public class Test0138_CopyListWithRandomPointer {
    private Node copyRandomList(Node head) {
        Map<Node, Node> memory = new HashMap<>();
        Node copy = new Node(0);
        Node origin = copy;
        while (head != null) {
            Node headCopy = getFromCache(head, memory);
            if (head.random != null) {
                headCopy.random = getFromCache(head.random, memory);
            }
            copy.next = headCopy;
            head = head.next;
            copy = copy.next;
        }
        return origin.next;
    }

    private Node getFromCache(Node node, Map<Node, Node> memory) {
        if (memory.containsKey(node)) {
            return memory.get(node);
        } else {
            Node copy = new Node(node.val);
            memory.put(node, copy);
            return copy;
        }
    }

    @Test
    public void test() {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;
        Node node = copyRandomList(n0);
        System.out.println(node);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
//            StringBuilder sb = new StringBuilder();
//            Node temp = this;
//            while (temp != null) {
//                sb.append("(" + temp.val + "," + (temp.random == null ? "null" : String.valueOf(temp.random.val)) + ")-->");
//                temp = temp.next;
//            }
//            return sb.toString();
        }
    }
}
