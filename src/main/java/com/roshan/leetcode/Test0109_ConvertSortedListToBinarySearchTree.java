package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.ListNode;
import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//        Example:
//        Given the sorted linked list: [-10,-3,0,5,9],
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//             0
//            / \
//          -3   9
//          /   /
//        -10  5
public class Test0109_ConvertSortedListToBinarySearchTree {
    private ListNode listNode;

    private TreeNode sortedListToBST(ListNode head) {
        listNode = head;
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return buildTree(0, size - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode leftChild = buildTree(left, mid - 1);
        TreeNode root = new TreeNode(listNode.val);
        listNode = listNode.next;
        root.left = leftChild;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    @Test
    public void test() {
        ListNode listNode = ListNode.build(-10, -3, 0, 5, 9);
        TreeNode node = sortedListToBST(listNode);
        System.out.println(node);
    }
}
