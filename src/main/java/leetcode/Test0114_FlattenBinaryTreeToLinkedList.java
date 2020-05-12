package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

//Given a binary tree, flatten it to a linked list in-place.
//        For example, given the following tree:
//            1
//           / \
//          2   5
//         / \   \
//        3   4   6
//        The flattened tree should look like:
//        1
//         \
//          2
//           \
//            3
//             \
//              4
//               \
//                5
//                 \
//                  6
public class Test0114_FlattenBinaryTreeToLinkedList {
    private void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            flatten(root.left);
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
        if (root.right != null) {
            flatten(root.right);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.build(1, 2, 5, 3, 4, null, 6);
        flatten(root);
        System.out.println(root);
    }
}
