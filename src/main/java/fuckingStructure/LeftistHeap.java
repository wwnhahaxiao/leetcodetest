package fuckingStructure;

import java.util.LinkedList;

public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {

    private Node<AnyType> root;

    public LeftistHeap() {
        root = null;
    }

    public void merge(LeftistHeap<AnyType> rhs) {
        if (this == rhs) {
            return;
        }
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x) {
        root = merge(new Node<>(x), root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return root.element;
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        AnyType minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    private static class Node<AnyType> {
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;

        Node(AnyType theElement) {
            this(theElement, null, null);
        }

        Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
            npl = 0;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element) < 0) {
            return merge1(h1, h2);
        } else {
            return merge1(h2, h1);
        }
    }

    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl) {
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<AnyType> t) {
        Node<AnyType> tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }

    public static void main(String[] args) {
        Node<Integer> left = new Node<>(3);
        left.left = new Node<>(10);
        left.left.left = new Node<>(21);
        left.left.right = new Node<>(14);
        left.left.right.left = new Node<>(23);
        left.right = new Node<>(8);
        left.right.left = new Node<>(17);
        left.right.left.left = new Node<>(26);
        LeftistHeap<Integer> leftHeap = new LeftistHeap<>();
        leftHeap.root = left;

        Node<Integer> right = new Node<>(6);
        right.left = new Node<>(12);
        right.left.left = new Node<>(18);
        right.left.right = new Node<>(24);
        right.left.right.left = new Node<>(33);
        right.right = new Node<>(7);
        right.right.left = new Node<>(37);
        right.right.right = new Node<>(18);
        LeftistHeap<Integer> rightHeap = new LeftistHeap<>();
        rightHeap.root = right;
        leftHeap.merge(rightHeap);
    }
}
