package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a non-empty binary tree, find the maximum path sum.
//        For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//        Example 1:
//        Input: [1,2,3]
//          1
//         / \
//        2   3
//        Output: 6
//        Example 2:
//        Input: [-10,9,20,null,null,15,7]
//           -10
//           / \
//          9  20
//            /  \
//           15   7
//        Output: 42
public class Test0124_BinaryTreeMaximumPathSum {
    private int max;

    private int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(maxSum(node.left), 0);
        int rightMax = Math.max(maxSum(node.right), 0);
        max = Math.max(node.val + leftMax + rightMax, max);
        return node.val + Math.max(leftMax, rightMax);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1,2,3,-4,-5,-6,-7);
        int i = maxPathSum(root);
        System.out.println(i);
    }
}
