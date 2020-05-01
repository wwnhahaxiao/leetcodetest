package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//        Note: A leaf is a node with no children.
//        Example:
//        Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//        Return:
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
public class Test0113_PathSumII {
    private List<List<Integer>> roads;

    private List<List<Integer>> pathSum(TreeNode root, int sum) {
        roads = new ArrayList<>();
        nextStep(root, new LinkedList<>(), sum);
        return roads;
    }

    private void nextStep(TreeNode node, LinkedList<Integer> road, int sum) {
        if (node == null) {
            return;
        }
        road.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            roads.add(new ArrayList<>(road));
        }
        if (node.left != null) {
            nextStep(node.left, road, sum);
        }
        if (node.right != null) {
            nextStep(node.right, road, sum);
        }
        road.removeLast();
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        List<List<Integer>> lists = pathSum(node, 22);
        System.out.println(lists);
    }
}
