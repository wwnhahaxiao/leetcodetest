package leetcode;

import leetcode.baseStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the preorder traversal of its nodes' values.
//        Example:
//        Input: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//        Output: [1,2,3]
//        Follow up: Recursive solution is trivial, could you do it iteratively?
public class Test0144_BinaryTreePreorderTraversal {
    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                TreeNode pos = root.left;
                while (pos.right != null && pos.right != root) {
                    pos = pos.right;
                }
                if (pos.right == null) {
                    pos.right = root;
                    result.add(root.val);
                    root = root.left;
                } else {
                    pos.right = null;
                    root = root.right;
                }
            }
        }
        return result;
    }
}
