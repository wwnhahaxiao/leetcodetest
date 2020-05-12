package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//        Each number in candidates may only be used once in the combination.
//        Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//        Input: candidates = [10,1,2,7,6,1,5], target = 8,
//        A solution set is:
//        [
//          [1, 7],
//          [1, 2, 5],
//          [2, 6],
//          [1, 1, 6]
//        ]
//        Example 2:
//        Input: candidates = [2,5,2,1,2], target = 5,
//        A solution set is:
//        [
//          [1,2,2],
//          [5]
//        ]
public class Test0040_CombinationSumII {
    private static int[] candidates;
    private static List<List<Integer>> result = new ArrayList<>();

    private List<List<Integer>> mySolution(int[] candidates, int target) {
        result.clear();
        Arrays.sort(candidates);
        this.candidates = candidates;
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            subNext(candidates[i], i, target, new Stack<>());
        }
        return result;
    }

    private void subNext(int val, int index, int target, Stack<Integer> stack) {
        int sub = target - val;
        stack.add(val);
        if (sub == 0) {
            result.add(stack);
        } else if (sub > 0) {
            int last = -1;
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i <= index) {//candidates[i] < val ||
                    continue;
                }
                if (last == candidates[i]) {
                    continue;
                }
                last = candidates[i];
                Stack<Integer> temp = new Stack<>();
                temp.addAll(stack);
                subNext(candidates[i], i, sub, temp);
            }
            for (int i : candidates) {
                if (i > target) {
                    break;
                }
                if (i <= val) {
                    continue;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        Test0040_CombinationSumII solution = new Test0040_CombinationSumII();
        List<List<Integer>> lists = solution.mySolution(candidates, target);
        System.out.println(lists);
    }
}
