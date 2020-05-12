package leetcode.baseStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node build(Integer... nums) {
        if (nums.length == 0) return null;
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(nums));
        List<Node> level = new ArrayList<>();
        Node root = new Node(list.remove());
        level.add(root);
        buildTree(list, level);
        return root;
    }

    private static void buildTree(LinkedList<Integer> nums, List<Node> level) {
        List<Node> nextLevel = new ArrayList<>();
        for (Node node : level) {
            if (nums.size() == 0) {
                return;
            }
            Integer leftValue = nums.remove();
            if (leftValue != null) {
                Node left = new Node(leftValue);
                node.left = left;
                nextLevel.add(left);
            }
            if (nums.size() == 0) {
                return;
            }
            Integer rightValue = nums.remove();
            if (rightValue != null) {
                Node right = new Node(rightValue);
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
