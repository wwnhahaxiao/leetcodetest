package com.roshan.leetcode;

import java.util.*;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//        Each element in the array represents your maximum jump length at that position.
//        Determine if you are able to reach the last index.
//        Example 1:
//        Input: [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//        Example 2:
//        Input: [3,2,1,0,4]
//        Output: false
//        Explanation: You will always arrive at index 3 no matter what. Its maximum
//        jump length is 0, which makes it impossible to reach the last index.
public class Test0055_JumpGame {
    private static boolean mySolution(int[] nums) {
        int max = 0;
        int past = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (past + nums[i] > max) {
                max = nums[i];
                past = 0;
            } else if (past >= max) {
                return false;
            }
            past++;
        }
        return true;
    }

    private static boolean mySolution2(int[] nums) {
        int pos = 0;
        int step = nums[0];
        int touch = nums[0];
        while (true) {
            if (touch >= nums.length - 1) {
                return true;
            }
            boolean forward = false;
            for (int i = pos + 1; i <= pos + step; i++) {
                if (nums[i] + i > touch) {
                    touch = i + nums[i];
                    pos = i;
                    step = nums[i];
                    forward = true;
                    break;
                }
            }
            if (!forward) {
                return false;
            }
        }
    }

    private static boolean mySolution3(int[] nums) {
        int max = nums[0];
        for (int i = 1; i <= max && i < nums.length - 1; i++) {
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        Map<int[], Boolean> map = new HashMap<>();
        map.put(new int[]{3, 2, 1, 0, 4}, false);
        map.put(new int[]{2, 3, 1, 1, 4}, true);
        map.put(new int[]{0, 1}, false);
        map.put(new int[]{1, 2, 3}, true);
        map.put(new int[]{2, 0, 1, 1, 2, 1, 0, 0, 0}, false);
        for (Map.Entry<int[], Boolean> entry : map.entrySet()) {
            if (mySolution3(entry.getKey()) != entry.getValue()) {
                System.out.println("failed:" + Arrays.toString(entry.getKey()));
                break;
            }
        }
        System.out.println("done");
    }
}
