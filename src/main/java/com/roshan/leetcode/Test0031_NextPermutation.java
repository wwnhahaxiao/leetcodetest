package com.roshan.leetcode;

import java.util.*;

//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//        The replacement must be in-place and use only constant extra memory.
//        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
public class Test0031_NextPermutation {
    private static void mySolution(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            for (int j = nums.length - 1; j > i ; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        for (int j = 0; j < (nums.length - 1 - i) / 2; j++) {
            int temp = nums[j + i + 1];
            nums[j + i + 1] = nums[nums.length - 1- j];
            nums[nums.length - 1- j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        mySolution(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
