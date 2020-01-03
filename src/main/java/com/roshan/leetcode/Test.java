package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        // if all integers are used up
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList<>();
        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) {
            nums_lst.add(num);
        }

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
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
}
