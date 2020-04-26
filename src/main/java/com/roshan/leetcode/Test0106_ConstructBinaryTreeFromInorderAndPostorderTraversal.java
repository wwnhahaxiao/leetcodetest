package com.roshan.leetcode;

import com.roshan.leetcode.baseStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//        Note:
//        You may assume that duplicates do not exist in the tree.
//        For example, given
//        inorder = [9,3,15,20,7]
//        postorder = [9,15,7,20,3]
//        Return the following binary tree:
//          3
//         / \
//        9  20
//          /  \
//         15   7
public class Test0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private static int[] in, post;
    private static Map<Integer, Integer> map;
    private static int postIndex;

    private static TreeNode mySolution(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        postIndex = post.length - 1;
        return buildNode(0, inorder.length - 1);
    }

    private static TreeNode buildNode(int start, int end) {
        if (start == end) {
            postIndex--;
            return new TreeNode(in[start]);
        } else if (start > end) {
            return null;
        } else {
            int value = post[postIndex--];
            TreeNode root = new TreeNode(value);
            int inIndex = map.get(value);
            root.right = buildNode(inIndex + 1, end);
            root.left = buildNode(start, inIndex - 1);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = mySolution(inOrder, postorder);
        System.out.println(treeNode);
    }
}
