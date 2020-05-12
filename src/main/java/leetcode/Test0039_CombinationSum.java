package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//        The same repeated number may be chosen from candidates unlimited number of times.
//        Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//        Input: candidates = [2,3,6,7], target = 7,
//        A solution set is:
//        [
//          [7],
//          [2,2,3]
//        ]
//        Example 2:
//        Input: candidates = [2,3,5], target = 8,
//        A solution set is:
//        [
//          [2,2,2,2],
//          [2,3,3],
//          [3,5]
//        ]
public class Test0039_CombinationSum {
    private static List<List<Integer>> mySolution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i : candidates) {
            addNext(0, target, i, new Stack<>(), candidates, result);
        }
        return result;
    }

    private static void addNext(int sum, int target, int i, Stack<Integer> stack, int[] candidates,
                                List<List<Integer>> list) {
        sum += i;
        stack.add(i);
        if (sum < target) {
            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] < i) {
                    continue;
                }
                if (sum + candidates[j] > target) {
                    break;
                }
                Stack<Integer> temp = new Stack<>();
                temp.addAll(stack);
                addNext(sum, target, candidates[j], temp, candidates, list);
            }
        } else if (sum > target) {
            return;
        } else {
            list.add(stack);
            return;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> lists = mySolution(nums, 7);
        System.out.println(lists);
    }

}
