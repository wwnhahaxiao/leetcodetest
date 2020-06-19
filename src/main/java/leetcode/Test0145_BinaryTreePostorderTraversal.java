package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
//Given a binary tree, return the postorder traversal of its nodes' values.
//        Example:
//        Input: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//        Output: [3,2,1]
//        Follow up: Recursive solution is trivial, could you do it iteratively?
public class Test0145_BinaryTreePostorderTraversal {
    private List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        postorderTraversal(root, path);
        return path;
    }

    private void postorderTraversal(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, path);
        postorderTraversal(root.right, path);
        path.add(root.val);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1,2,3,4,5,6,7);
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }
}
