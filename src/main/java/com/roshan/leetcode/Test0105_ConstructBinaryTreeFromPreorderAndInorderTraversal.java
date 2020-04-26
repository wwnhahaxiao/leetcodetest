package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

//Given preorder and inorder traversal of a tree, construct the binary tree.
//        Note:
//        You may assume that duplicates do not exist in the tree.
//        For example, given
//        preorder = [3,9,20,15,7]
//        inorder = [9,3,15,20,7]
//        Return the following binary tree:
//        3
//        / \
//        9  20
//        /  \
//        15   7
public class Test0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static int[] pre, in;
    private static Map<Integer, Integer> map;
    private static int preIndex;

    private static TreeNode mySolution(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        preIndex = 0;
        return buildNode(0, inorder.length - 1);
    }

    private static TreeNode buildNode(int start, int end) {
        if (start == end) {
            preIndex++;
            return new TreeNode(in[start]);
        } else if (start > end) {
            return null;
        } else {
            int value = pre[preIndex++];
            TreeNode root = new TreeNode(value);
            int inIndex = map.get(value);
            root.left = buildNode(start, inIndex - 1);
            root.right = buildNode(inIndex + 1, end);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode treeNode = mySolution(preOrder, inOrder);
        System.out.println(treeNode);
    }
}
