package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]
public class Test0102_BinaryTreeLevelOrderTraversal {
    private static List<List<Integer>> result;

    private static List<List<Integer>> mySolution(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        levelTraversal(rootLevel);
        return result;
    }

    private static void levelTraversal(List<TreeNode> level) {
        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (TreeNode node : level) {
            list.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        result.add(list);
        if (!nextLevel.isEmpty()) {
            levelTraversal(nextLevel);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = mySolution(root);
        System.out.println(lists);
    }
}
