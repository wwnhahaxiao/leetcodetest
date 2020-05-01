package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a binary tree, find its minimum depth.
//        The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//        Note: A leaf is a node with no children.
//        Example:
//        Given binary tree [3,9,20,null,null,15,7],
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its minimum depth = 2.
public class Test0111_MinimumDepthOfBinaryTree {
    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1, 2);
//        TreeNode root = TreeNode.build(7);
        System.out.println(minDepth(root));
    }
}
