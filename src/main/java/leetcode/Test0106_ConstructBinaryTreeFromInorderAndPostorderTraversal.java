package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//        Note:
//        You may assume that duplicates do not exist in the tree.
//        For example, given
//        inorder = [9,3,15,20,7]
//        postorder = [9,15,7,20,3]
//        Return the following binary tree:
//          3
//         / \
//        9  20
//          /  \
//         15   7
public class Test0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private int[] in, post;
    private Map<Integer, Integer> map;
    private int postIndex;

    private TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        postIndex = post.length - 1;
        return buildNode(0, inorder.length - 1);
    }

    private TreeNode buildNode(int start, int end) {
        if (start == end) {
            postIndex--;
            return new TreeNode(in[start]);
        } else if (start > end) {
            return null;
        } else {
            int value = post[postIndex--];
            TreeNode root = new TreeNode(value);
            int inIndex = map.get(value);
            root.right = buildNode(inIndex + 1, end);
            root.left = buildNode(start, inIndex - 1);
            return root;
        }
    }

    @Test
    public void test() {
        int[] inOrder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inOrder, postorder);
        System.out.println(treeNode);
    }
}
