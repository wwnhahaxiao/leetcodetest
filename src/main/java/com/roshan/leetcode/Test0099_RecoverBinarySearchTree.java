package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

//Two elements of a binary search tree (BST) are swapped by mistake.
//        Recover the tree without changing its structure.
//        Example 1:
//        Input: [1,3,null,null,2]
//           1
//          /
//         3
//          \
//           2
//        Output: [3,1,null,null,2]
//           3
//          /
//         1
//          \
//           2
//        Example 2:
//        Input: [3,1,4,null,null,2]
//         3
//        / \
//       1   4
//          /
//         2
//        Output: [2,1,4,null,null,3]
//         2
//        / \
//       1   4
//          /
//        3
//        Follow up:
//        A solution using O(n) space is pretty straight forward.
//        Could you devise a constant space solution?
public class Test0099_RecoverBinarySearchTree {
    private static TreeNode x, y;

    public static void mySolution(TreeNode root) {
        x = y = null;
        TreeNode pre = null;
        while (root != null) {
            if (root.left == null) {
                recordErrPoint(pre, root);
                pre = root;
                root = root.right;
            } else {
                TreeNode pos = root.left;
                while (pos.right != null && pos.right != root) {
                    pos = pos.right;
                }
                if (pos.right == null) {
                    pos.right = root;
                    root = root.left;
                } else {
                    pos.right = null;
                    recordErrPoint(pre, root);
                    pre = root;
                    root = root.right;
                }
            }
        }
        swap(x, y);
    }

    private static void recordErrPoint(TreeNode pre, TreeNode curr) {
        if (pre != null && curr.val < pre.val) {
            if (x == null) {
                x = pre;
                y = curr;
            } else {
                y = curr;
            }
        }
    }

    public static void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        mySolution(root);
        System.out.println(root);
    }
}
