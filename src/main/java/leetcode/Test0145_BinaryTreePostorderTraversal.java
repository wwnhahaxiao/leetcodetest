package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
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
    private List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode remove = stack.removeFirst();
            if (remove.left != null) {
                stack.addFirst(remove.left);
            }
            if (remove.right != null) {
                stack.addFirst(remove.right);
            }
            result.addFirst(remove.val);
        }
        return result;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list = postorderTraversal2(root);
        System.out.println(list);
    }
}
