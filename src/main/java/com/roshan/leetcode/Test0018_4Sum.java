package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//        Note:
//        The solution set must not contain duplicate quadruplets.
//        Example:
//        Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//        A solution set is:
//        [
//        [-1,  0, 0, 1],
//        [-2, -1, 1, 2],
//        [-2,  0, 0, 2]
//        ]
public class Test0018_4Sum {
    private static List<List<Integer>> mySolution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //最小值比target大结束(i越大结果越大,所以直接break)
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //最大值比target小(i越大结果越大,所以只能continue)
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                //最小值比target大
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    continue;
                }
                //最大值比target小
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        while (nums[left] == nums[++left] && left < right);
                    } else if (sum > target) {
                        while (nums[right] == nums[--right] && left < right);
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (nums[left] == nums[++left] && left < right);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> lists = mySolution(nums, 0);
        lists .forEach(System.out::println);
    }
}
