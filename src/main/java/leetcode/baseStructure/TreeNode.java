package leetcode.baseStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode build(Integer... nums) {
        if (nums.length == 0) return null;
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(nums));
        List<TreeNode> level = new ArrayList<>();
        TreeNode root = new TreeNode(list.remove());
        level.add(root);
        buildTree(list, level);
        return root;
    }

    private static void buildTree(LinkedList<Integer> nums, List<TreeNode> level) {
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : level) {
            if (nums.size() == 0) {
                return;
            }
            Integer leftValue = nums.remove();
            if (leftValue != null) {
                TreeNode left = new TreeNode(leftValue);
                node.left = left;
                nextLevel.add(left);
            }
            if (nums.size() == 0) {
                return;
            }
            Integer rightValue = nums.remove();
            if (rightValue != null) {
                TreeNode right = new TreeNode(rightValue);
                node.right = right;
                nextLevel.add(right);
            }
        }
        buildTree(nums, nextLevel);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
