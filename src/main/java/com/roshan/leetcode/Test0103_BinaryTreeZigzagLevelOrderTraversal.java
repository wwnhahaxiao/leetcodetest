package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
public class Test0103_BinaryTreeZigzagLevelOrderTraversal {
    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        boolean forward = true;
        while (!level.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = level.size();
            if (forward) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = level.removeFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        level.addLast(node.left);
                    }
                    if (node.right != null) {
                        level.addLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = level.removeLast();
                    list.add(node.val);
                    if (node.right != null) {
                        level.addFirst(node.right);
                    }
                    if (node.left != null) {
                        level.addFirst(node.left);
                    }
                }
            }
            forward = !forward;
            result.add(list);
        }
        return result;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
