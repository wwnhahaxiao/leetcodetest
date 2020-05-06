package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its bottom-up level order traversal as:
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]
public class Test0107_BinaryTreeLevelOrderTraversalII {
    private List<List<Integer>> result;

    private List<List<Integer>> levelTraversal(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        traversal(rootLevel);
        return result;
    }

    private void traversal(List<TreeNode> level) {
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
        if (!nextLevel.isEmpty()) {
            traversal(nextLevel);
        }
        result.add(list);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> lists = levelTraversal(root);
        System.out.println(lists);
    }
}
