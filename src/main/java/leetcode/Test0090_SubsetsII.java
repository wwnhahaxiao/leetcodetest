package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//        Note: The solution set must not contain duplicate subsets.
//        Example:
//        Input: [1,2,2]
//        Output:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]
public class Test0090_SubsetsII {
    private static int[] arr;
    private static List<List<Integer>> result;

    private static List<List<Integer>> mySolution(int[] nums) {
        Arrays.sort(nums);
        arr = nums;
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrack(0, new ArrayList<>());
        return result;
    }

    private static void backtrack(int index, List<Integer> list) {
        int prev = 0;
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == prev) {
                continue;
            }
            list.add(arr[i]);
            result.add(new ArrayList<>(list));
            backtrack(i + 1, list);
            list.remove(list.size() - 1);
            prev = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = mySolution(nums);
        System.out.println(lists);
    }
}
