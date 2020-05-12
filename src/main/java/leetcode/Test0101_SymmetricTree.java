package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//          1
//         / \
//        2   2
//       / \ / \
//      3  4 4  3
//        But the following [1,2,2,null,3,null,3] is not:
//         1
//        / \
//       2   2
//        \   \
//        3    3
//        Follow up: Solve it both recursively and iteratively.
public class Test0101_SymmetricTree {
    private boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5);
        System.out.println(isSymmetric(root));
    }
}
