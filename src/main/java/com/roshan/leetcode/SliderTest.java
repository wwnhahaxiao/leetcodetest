package com.roshan.leetcode;

import java.util.Arrays;

public class SliderTest {
    public static int mySolution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int mid = nums.length / 2;
        //中间最大子串左半部分最大值
        int lmax = 0;
        int ltotal = 0;
        for (int i = mid; i >= 0 ; i--) {
            ltotal += nums[i];
            lmax = Math.max(lmax, ltotal);
        }
        //中间最大子串右半部分最大值
        int rmax = 0;
        int rtotal = 0;
        for (int i = mid + 1; i < nums.length; i++) {
            rtotal += nums[i];
            rmax = Math.max(rmax, rtotal);
        }
        int middle = lmax + rmax;
        int[] l = Arrays.copyOf(nums, mid);
        int left = mySolution(l);
        int[] r = Arrays.copyOfRange(nums, mid, nums.length);
        int right = mySolution(r);
        int max = Math.max(left, middle);
        max = Math.max(max, right);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,-2,3,6,-8};
        System.out.println(mySolution(nums));
    }
}
