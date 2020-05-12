package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a binary tree, find its maximum depth.
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//        Note: A leaf is a node with no children.
//        Example:
//        Given binary tree [3,9,20,null,null,15,7],
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        return its depth = 3.
public class Test0104_MaximumDepthOfBinaryTree {
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(3, 9, 20, null, null, 15, 7);
        int deep = maxDepth(root);
        System.out.println(deep);
    }
}
