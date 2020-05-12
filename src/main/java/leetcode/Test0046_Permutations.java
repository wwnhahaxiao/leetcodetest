package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
//        Example:
//        Input: [1,2,3]
//        Output:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Test0046_Permutations {
    /*
    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表移除
        路径.add(选择)
        backtrack(路径, 选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择再加入选择列表
     */
    private static List<List<Integer>> mySolution(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, list, result);
        return result;
    }
    private static void backtrack(int[] nums, LinkedList<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(nums, list, result);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = mySolution(nums);
    }
}
