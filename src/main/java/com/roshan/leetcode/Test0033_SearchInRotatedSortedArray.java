package com.roshan.leetcode;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//        You are given a target value to search. If found in the array return its index, otherwise return -1.
//        You may assume no duplicate exists in the array.
//        Your algorithm's runtime complexity must be in the order of O(log n).
//        Example 1:
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1
public class Test0033_SearchInRotatedSortedArray {
    private static int mySolution(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0, mid, end = nums.length - 1;
        //二分查找最大值的位置
        if (nums[start] > nums[end]) {
            while (start < end) {
                mid = (start + end + 1) / 2;
                //旋转点在左边
                if (nums[start] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
            mid = start;
            start = 0;
            end = nums.length - 1;
            if (target < nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        //查找target位置
        while (start <= end) {
            mid = (start + end + 1) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int target = 5;
        System.out.println(mySolution(nums, target));
//        System.out.println(search(nums, 1));
    }
}
