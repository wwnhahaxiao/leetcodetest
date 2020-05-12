package leetcode;

import leetcode.baseStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
//        Example:
//
//        Input: 3
//        Output:
//        [
//          [1,null,3,2],
//          [3,2,null,1],
//          [3,1,null,null,2],
//          [2,1,3],
//          [1,null,2,null,3]
//        ]
//        Explanation:
//        The above output corresponds to the 5 unique BST's shown below:
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3
public class Test0095_UniqueBinarySearchTreesII {

    private static List<TreeNode> mySolution(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1, n);
    }

    private static List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChildren = genTrees(start, i - 1);
            List<TreeNode> rightChildren = genTrees(i + 1, end);
            for (TreeNode left : leftChildren) {
                for (TreeNode right : rightChildren) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = mySolution(4);
        System.out.println(treeNodes);
    }

}
