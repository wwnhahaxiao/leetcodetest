package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

//Given two binary trees, write a function to check if they are the same or not.
//        Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//        Example 1:
//        Input:     1         1
//                  / \       / \
//                 2   3     2   3
//                [1,2,3],   [1,2,3]
//        Output: true
//        Example 2:
//        Input:     1         1
//                  /           \
//                 2             2
//               [1,2],     [1,null,2]
//        Output: false
//        Example 3:
//        Input:     1         1
//                  / \       / \
//                 2   1     1   2
//                [1,2,1],   [1,1,2]
//        Output: false
public class Test0100_SameTree {
    private static boolean mySolution(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && mySolution(p.left, q.left) && mySolution(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        TreeNode first = new TreeNode(1);
//        first.left = new TreeNode(2);
//        first.right = new TreeNode(3);
//        TreeNode second = new TreeNode(1);
//        second.left = new TreeNode(2);
//        second.right = new TreeNode(3);

        TreeNode first = new TreeNode(1);
        first.left = new TreeNode(2);
        TreeNode second = new TreeNode(1);
        second.right = new TreeNode(2);
        System.out.println(mySolution(first, second));
    }
}
