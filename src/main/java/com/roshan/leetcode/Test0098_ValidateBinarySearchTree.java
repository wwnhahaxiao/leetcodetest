package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//        Assume a BST is defined as follows:
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//        Example 1:
//        2
//        / \
//        1   3
//        Input: [2,1,3]
//        Output: true
//        Example 2:
//        5
//        / \
//        1   4
//             / \
//            3   6
//        Input: [5,1,4,null,null,3,6]
//        Output: false
//        Explanation: The root node's value is 5 but its right child's value is 4.
public class Test0098_ValidateBinarySearchTree {

    /**
     * 递归写法
     */
    private static boolean mySolution(TreeNode root) {
        return checkNode(root, null, null);
    }
    private static boolean checkNode(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (min != null && val < min) {
            return false;
        }
        if (max != null && val > max) {
            return false;
        }
        if (!checkNode(node.left, min, val)) {
            return false;
        }
        if (!checkNode(node.right, val, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(mySolution(root));
    }

    /**
     * @see Test0094_BinaryTreeInorderTraversal
     * 中序遍历该二叉树获得的数组必然正序排列
     */
    private static boolean mySolution2(TreeNode root) {
        Integer pre = null;
        while (root != null) {
            if (root.left == null) {
                //list add
                if (pre == null) {
                    pre = root.val;
                } else if (root.val <= pre) {
                    return false;
                } else {
                    pre = root.val;
                }
                root = root.right;
            } else {
                TreeNode curr = root;
                root = root.left;
                while (root.right != null) {
                    root = root.right;
                }
                root.right = curr;
                root = curr.left;
                curr.left = null;
            }
        }
        return true;
    }

}
