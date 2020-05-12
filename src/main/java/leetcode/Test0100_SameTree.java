package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given two binary trees, write a function to check if they are the same or not.
//        Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//        Example 1:
//        Input:     1         1
//                  / \       / \
//                 2   3     2   3
//                [1,2,3],   [1,2,3]
//        Output: true
//        Example 2:
//        Input:     1         1
//                  /           \
//                 2             2
//               [1,2],     [1,null,2]
//        Output: false
//        Example 3:
//        Input:     1         1
//                  / \       / \
//                 2   1     1   2
//                [1,2,1],   [1,1,2]
//        Output: false
public class Test0100_SameTree {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        TreeNode first = TreeNode.build(1, 2);
        TreeNode second = TreeNode.build(1, null, 2);
        System.out.println(isSameTree(first, second));
    }
}
