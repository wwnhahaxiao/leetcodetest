package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//        Example:
//        Given the sorted array: [-10,-3,0,5,9],
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//             0
//            / \
//          -3   9
//          /   /
//        -10  5
public class Test0108_ConvertSortedArrayToBinarySearchTree {

    private int[] arr;

    private TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        arr = nums;
        return buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = buildTree(left, mid - 1);
            node.right = buildTree(mid + 1, right);
            return node;
        } else if (left == right) {
            return new TreeNode(arr[left]);
        } else {
            return null;
        }
    }

    @Test
    public void test() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node);
    }
}