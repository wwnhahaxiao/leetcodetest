package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

import java.util.List;

//Given a binary tree, find its maximum depth.
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//        Note: A leaf is a node with no children.
//        Example:
//        Given binary tree [3,9,20,null,null,15,7],
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its depth = 3.
public class Test0104_MaximumDepthOfBinaryTree {
    private static int mySolution(TreeNode root) {
        if (root == null) return 0;
        return Math.max(mySolution(root.left), mySolution(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int deep = mySolution(root);
        System.out.println(deep);
    }
}
