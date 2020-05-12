package leetcode;

import leetcode.baseStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the inorder traversal of its nodes' values.
//        Example:
//        Input: [1,null,2,3]
//        1
//        \
//        2
//        /
//        3
//        Output: [1,3,2]
//        Follow up: Recursive solution is trivial, could you do it iteratively?
public class Test0094_BinaryTreeInorderTraversal {

    /*
    Step 1: 将当前节点current初始化为根节点
    Step 2: While current不为空，
        若current没有左子节点
            a. 将current添加到输出
            b. 进入右子树，亦即, current = current.right
        否则
            a. 在current的左子树中，令current成为最右侧节点的右子节点
            b. 进入左子树，亦即，current = current.left
     */
    private static List<Integer> mySolution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr;
                curr = curr.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = pre;
                curr = pre.left;
                pre.left = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(1,null,2,3);
        List<Integer> integers = mySolution(root);
        System.out.println(integers);
    }

}
