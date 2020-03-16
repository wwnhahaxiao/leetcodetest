package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//        Find the minimum element.
//        You may assume no duplicate exists in the array.
//        Example 1:
//        Input: [3,4,5,1,2]
//        Output: 1
//        Example 2:
//        Input: [4,5,6,7,0,1,2]
//        Output: 0
public class Test0153_FindMinimumInRotatedSortedArray {
    private static int mySolution(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            System.out.println("counting");
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 1, 2};
        int[] b = new int[]{4, 5, 6, 7, 0, 1, 2};
    }
}
