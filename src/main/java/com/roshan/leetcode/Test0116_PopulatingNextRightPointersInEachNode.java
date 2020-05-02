package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.Node;
import org.junit.Test;

import java.util.LinkedList;

//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//        struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//        }
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//        Initially, all next pointers are set to NULL.
//        Follow up:
//        You may only use constant extra space.
//        Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
//        Example 1:
//        Input: root = [1,2,3,4,5,6,7]
//        Output: [1,#,2,3,#,4,5,6,7,#]
//        Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//        Constraints:
//        The number of nodes in the given tree is less than 4096.
//        -1000 <= node.val <= 1000
public class Test0116_PopulatingNextRightPointersInEachNode {
    private Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> level = new LinkedList<>();
        level.add(root);
        connectNextLevel(level);
        return root;
    }

    private void connectNextLevel(LinkedList<Node> level) {
        LinkedList<Node> nextLevel = new LinkedList<>();
        Node pre = null;
        for (Node node : level) {
            if (pre == null) {
                pre = node;
            } else {
                pre.next = node;
                pre = node;
            }
            if (pre.left != null) {
                nextLevel.add(pre.left);
            }
            if (pre.right != null) {
                nextLevel.add(pre.right);
            }
        }
        if (nextLevel.size() > 0) {
            connectNextLevel(nextLevel);
        }
    }

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node connect = connect(root);
        System.out.println(connect);
    }
}
