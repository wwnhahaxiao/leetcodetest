package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.Node;
import org.junit.Test;

import java.util.HashMap;

//Given a binary tree
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
//        Input: root = [1,2,3,4,5,null,7]
//        Output: [1,#,2,3,#,4,5,7,#]
//        Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//        Constraints:
//        The number of nodes in the given tree is less than 6000.
//        -100 <= node.val <= 100
public class Test0117_PopulatingNextRightPointersInEachNodeII {
    private Node pre;
    private Node first;
    private Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node origin = root;
        pre = null;
        first = null;
        while (root != null) {
            if (root.left != null) {
                connectNext(root.left);
            }
            if (root.right != null) {
                connectNext(root.right);
            }
            root = root.next;
        }
        if (first != null) {
            connect(first);
        }
        return origin;
    }

    private void connectNext(Node node) {
        if (node != null) {
            if (pre == null) {
                pre = node;
                if (first == null) {
                    first = pre;
                }
            } else {
                pre.next = node;
                pre = node;
            }
        }
    }

    @Test
    public void test() {
//        Node root = Node.build(1, 2, 3, 4, null, null, 5);
        Node root = Node.build(2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7);
        Node connect = connect(root);
        System.out.println(connect);
    }
}
