package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a binary tree, determine if it is height-balanced.
//        For this problem, a height-balanced binary tree is defined as:
//        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//        Example 1:
//        Given the following tree [3,9,20,null,null,15,7]:
//          3
//         / \
//        9  20
//          /  \
//         15   7
//        Return true.
//        Example 2:
//        Given the following tree [1,2,2,3,3,null,null,4,4]:
//              1
//             / \
//            2   2
//           / \
//          3   3
//         / \
//        4   4
//        Return false.
public class Test0110_BalancedBinaryTree {
    private boolean balance;

    private boolean isBalanced(TreeNode root) {
        balance = true;
        getHeight(root);
        return balance;
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) return 1;
        if (!balance) {
            return 0;
        }
        int left = getHeight(treeNode.left);
        int right = getHeight(treeNode.right);
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        return Math.max(left, right) + 1;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }
}
