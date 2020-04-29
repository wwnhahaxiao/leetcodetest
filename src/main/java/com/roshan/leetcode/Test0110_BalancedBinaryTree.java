package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, determine if it is height-balanced.
//        For this problem, a height-balanced binary tree is defined as:
//        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//        Example 1:
//        Given the following tree [3,9,20,null,null,15,7]:
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        Return true.
//        Example 2:
//        Given the following tree [1,2,2,3,3,null,null,4,4]:
//              1
//             / \
//            2   2
//           / \
//          3   3
//         / \
//        4   4
//        Return false.
public class Test0110_BalancedBinaryTree {
    private List<Integer> height;

    private boolean isBalanced(TreeNode root) {
        height = new ArrayList<>();
        findLeaf(root, 0);
        int max = 0, min = Integer.MAX_VALUE;
        for (Integer high : height) {
            max = Math.max(max, high);
            min = Math.min(min, high);
            if (max - min > 1) {
                return false;
            }
        }
        return true;
    }

    private void findLeaf(TreeNode treeNode, int high) {
        if (treeNode == null) {
            height.add(high);
        } else {
            findLeaf(treeNode.left, high + 1);
            findLeaf(treeNode.right, high + 1);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(3,9,20,null,null,15,7);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }
}
