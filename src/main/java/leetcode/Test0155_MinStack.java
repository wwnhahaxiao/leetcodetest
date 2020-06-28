package leetcode;

import org.junit.Test;

import java.util.ArrayList;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
//        Example 1:
//        Input
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//        Output
//        [null,null,null,null,-3,null,0,-2]
//        Explanation
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin(); // return -3
//        minStack.pop();
//        minStack.top();    // return 0
//        minStack.getMin(); // return -2
//        Constraints:
//        Methods pop, top and getMin operations will always be called on non-empty stacks.
public class Test0155_MinStack {
    class MinStack {
        private Node head;
        private Node sort;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            if (this.head == null) {
                this.sort = new Node(x);
            } else {
                Node min = new Node(Math.min(x, this.sort.val));
                min.next = sort;
                sort = min;
            }
            Node node = new Node(x);
            node.next = this.head;
            this.head = node;
        }

        public void pop() {
            this.head = head.next;
            this.sort = sort.next;
        }

        public int top() {
            return this.head.val;
        }

        public int getMin() {
            return this.sort.val;
        }

        private class Node {
            private int val;
            private Node next;

            public Node(int val) {
                this.val = val;
            }
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        if (minStack.getMin() != -3) {
            System.out.println("getMin error");
        }
        minStack.pop();
        if (minStack.top() != 0) {
            System.out.println("top error");
        }
        if (minStack.getMin() != -2) {
            System.out.println("getMin error");
        }
    }
}
