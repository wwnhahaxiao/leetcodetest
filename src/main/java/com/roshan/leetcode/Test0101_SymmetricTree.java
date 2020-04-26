package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//          1
//         / \
//        2   2
//       / \ / \
//      3  4 4  3
//        But the following [1,2,2,null,3,null,3] is not:
//         1
//        / \
//       2   2
//        \   \
//        3    3
//        Follow up: Solve it both recursively and iteratively.
public class Test0101_SymmetricTree {
    private static boolean mySolution(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);
        System.out.println(mySolution(root));
    }
}
