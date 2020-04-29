package com.roshan.leetcode.baseStructure;

import java.util.Arrays;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode build(Integer... nums) {
        return buildTree(new LinkedList(Arrays.asList(nums)));
    }

    private static TreeNode buildTree(LinkedList<Integer> nums) {
        if (nums.size() == 0) {
            return null;
        } else {
            Integer value = nums.remove();
            if (value == null) {
                return null;
            }
            TreeNode node = new TreeNode(value);
            node.left = buildTree(nums);
            node.right = buildTree(nums);
            return node;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
