package leetcode;

import java.util.LinkedList;
import java.util.List;

//Given a set of distinct integers, nums, return all possible subsets (the power set).
//        Note: The solution set must not contain duplicate subsets.
//        Example:
//        Input: nums = [1,2,3]
//        Output:
//        [
//        [3],
//          [1],
//          [2],
//          [1,2,3],
//          [1,3],
//          [2,3],
//          [1,2],
//          []
//        ]
public class Test0078_Subsets {

    private static List<List<Integer>> result;

    private static List<List<Integer>> mySolution(int[] nums) {
        result = new LinkedList<>();
        getNextPermutation(nums, 0, new LinkedList<>());
        result.add(new LinkedList<>());
        return result;
    }

    private static void getNextPermutation(int[] ints, int first, LinkedList<Integer> list) {
        for (int i = first; i < ints.length; i++) {
            list.add(ints[i]);
            result.add(new LinkedList<>(list));
            getNextPermutation(ints, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> lists = mySolution(nums);
        System.out.println(lists);
    }
}
