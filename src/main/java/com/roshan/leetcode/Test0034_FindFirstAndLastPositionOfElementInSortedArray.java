package com.roshan.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Test0034_FindFirstAndLastPositionOfElementInSortedArray {
    @Test
    public void test() {
        int[] nums = new int[]{0,1,2,3,4,5,6,6};
        int target = 6;
        int[] ret = searchRange(nums, target);
        System.out.println("result:[" + ret[0] + "," + ret[1] + "]");
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        if (length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int middle = length / 2;
        if (nums[middle] < target) {
            int[] larger = Arrays.copyOfRange(nums, middle, length);
            return searchRange(larger, target);
        } else if (nums[middle] > target) {
            int[] smaller = Arrays.copyOf(nums, middle);
            return searchRange(smaller, target);
        } else if (nums[middle] == target) {
            return new int[]{666, 666};
        }
        return new int[0];
    }
}
