package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//        Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
public class Test0001_TwoSum {
    private static int[] mySolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = mySolution(nums, target);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
