package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]
public class Test0102_BinaryTreeLevelOrderTraversal {
    private List<List<Integer>> result;

    private List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        levelTraversal(rootLevel);
        return result;
    }

    private void levelTraversal(List<TreeNode> level) {
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
        result.add(list);
        if (!nextLevel.isEmpty()) {
            levelTraversal(nextLevel);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }
}
