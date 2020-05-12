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

    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return root.element;
    }

    public AnyType deleteMin() {
        return null;
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

    }

    public void build(AnyType rootValue, AnyType... values) {
        LinkedList<Node<AnyType>> list = new LinkedList<>();
        this.root = new Node<>(rootValue);
        list.add(root);
        for (AnyType value : values) {
            Node<AnyType> node = list.remove();
            if (node.left == null) {
                node.left = new Node<>(value);
                list.addFirst(node);
                list.add(node.left);
            } else {
                node.right = new Node<>(value);
                list.add(node.right);
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(root);
    }
}
