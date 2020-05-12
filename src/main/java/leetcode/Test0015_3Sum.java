package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
//  Find all unique triplets in the array which gives the sum of zero.
//        Note:
//        The solution set must not contain duplicate triplets.
//        Example:
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]
public class Test0015_3Sum {
    private static List<List<Integer>> mySolution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int num = nums[i] + nums[j] + nums[k];
                if (num < 0) {
                    j++;
                } else if (num > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(mySolution(test));
    }
}
