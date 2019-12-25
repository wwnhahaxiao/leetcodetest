package com.roshan.leetcode;

//Given an unsorted integer array, find the smallest missing positive integer.
//        Example 1:
//        Input: [1,2,0]
//        Output: 3
//        Example 2:
//        Input: [3,4,-1,1]
//        Output: 2
//        Example 3:
//        Input: [7,8,9,11,12]
//        Output: 1
//        Note:
//        Your algorithm should run in O(n) time and uses constant extra space.
public class Test0041_FirstMissingPositive {
    private static int mySolution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //把nums按顺序排放 把num[i]放至num[num[i]-1]中
            //while i位置的值v所应该在的位置num[v-1]不是v 把v放到num[v-1]中去
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(mySolution(nums));
    }
}
