package com.roshan.leetcode;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//        Example:
//        Input: [-2,1,-3,4,-1,2,1,-5,4],
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
//        Follow up:
//        If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
public class Test0053_MaximumSubarray {
    private static int mySolution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return max(nums, 0, nums.length - 1);
    }
    private static int max(int[] nums, int begin, int end) {
        if (begin == end) {
            return nums[begin];
        }
        //假设最大的子串包含nums[mid]
        int mid = (begin + end) / 2;
        //左半部分子串最大值
        int leftMax = Integer.MIN_VALUE;
        int total = 0;
        for (int i = mid; i >= begin; i--) {
            total += nums[i];
            leftMax = Math.max(total, leftMax);
        }
        //右半部分字串最大值
        int rightMax = Integer.MIN_VALUE;
        total = 0;
        for (int i = mid + 1; i <= end; i++) {
            total += nums[i];
            rightMax = Math.max(total, rightMax);
        }
        //包含nums[mid]的最大字串和为max
        int max = leftMax + rightMax;
        //如果最大的子串不包含nums[mid] 但在nums[mid]左侧
        int lMax = max(nums, begin, mid);
        //如果最大的子串不包含nums[mid] 但在nums[mid]右侧
        int rMax = max(nums, mid + 1, end);
        //最大字串为3种情况种最大的
        return Math.max(max, Math.max(lMax, rMax));
    }

    public static void main(String[] args) {
        int[] temp = {1,-1,1,-1,1};
        System.out.println(mySolution(temp));
    }
}
