package leetcode;

import leetcode.baseStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//        Calling next() will return the next smallest number in the BST.
//        Example:
//        BSTIterator iterator = new BSTIterator(root);
//        iterator.next();    // return 3
//        iterator.next();    // return 7
//        iterator.hasNext(); // return true
//        iterator.next();    // return 9
//        iterator.hasNext(); // return true
//        iterator.next();    // return 15
//        iterator.hasNext(); // return true
//        iterator.next();    // return 20
//        iterator.hasNext(); // return false
//        Note:
//        next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
//        You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
public class Test0173_BinarySearchTreeIterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator {
        private List<Integer> sorted;
        private Integer index;

        public BSTIterator(TreeNode root) {
            this.sorted = new ArrayList<>();
            this.index = -1;
            _inorder(root);
        }

        private void _inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            this._inorder(root.left);
            this.sorted.add(root.val);
            this._inorder(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return this.sorted.get(++this.index);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < this.sorted.size() - 1;
        }
    }

    @Test
    public void test() {
        BSTIterator iterator = new BSTIterator(TreeNode.build(7,3,15,null,null,9,20));
        if (iterator.next() != 3) {
            System.out.println("next 3 error");
            return;
        }
        if (iterator.next() != 7) {
            System.out.println("next 7 error");
            return;
        }
        if (!iterator.hasNext()) {
            System.out.println("hasNext error");
            return;
        }
        if (iterator.next() != 9) {
            System.out.println("next 9 error");
            return;
        }
        if (!iterator.hasNext()) {
            System.out.println("hasNext error");
            return;
        }
        if (iterator.next() != 15) {
            System.out.println("next 15 error");
            return;
        }
        if (!iterator.hasNext()) {
            System.out.println("hasNext error");
            return;
        }
        if (iterator.next() != 20) {
            System.out.println("next 20 error");
            return;
        }
        if (iterator.hasNext()) {
            System.out.println("hasNext error");
            return;
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
