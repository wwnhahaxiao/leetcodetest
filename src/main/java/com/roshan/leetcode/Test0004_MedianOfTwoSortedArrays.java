package com.roshan.leetcode;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//        You may assume nums1 and nums2 cannot be both empty.
//        Example 1:
//        nums1 = [1, 3]
//        nums2 = [2]
//        The median is 2.0
//        Example 2:
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5
public class Test0004_MedianOfTwoSortedArrays {
    private static double mySolution(int[] nums1, int[] nums2) {
        int k = (nums1.length + nums2.length + 1) / 2;
        int currentA = 0, currentB = 0;
        while (k != 1) {
            int indexA = currentA + k / 2, indexB = currentB + k / 2;
            if (nums1.length - 1 < indexA) {
                indexA = nums1.length - 1;
            }
            if (nums2.length - 1 < indexB) {
                indexB = nums2.length - 1;
            }
            if (nums1[indexA] < nums2[indexB]) {
                k -= indexA - currentA;
                if (currentA == indexA) {
                    return nums2[currentB + k - 2];
                }
                currentA = indexA;
            } else {
                k -= indexB - currentB;
                if (currentA == indexA) {
                    return nums1[currentA + k - 2];
                }
                currentB = indexB;
            }
        }
        return Math.min(nums1[currentA], nums2[currentB]);
    }

    private static double mySolution2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            if (nums1.length == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d;
            } else if (nums2.length == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d;
            }
            return (findKthSmallestNum(nums1, nums2, len / 2, 0, 0) + findKthSmallestNum(nums1, nums2, (len + 2) / 2, 0, 0)) / 2d;
        } else {
            if (nums1.length == 0) {
                return nums2[nums2.length / 2];
            } else if (nums2.length == 0) {
                return nums1[nums1.length / 2];
            }
            return findKthSmallestNum(nums1, nums2, (nums1.length + nums2.length + 1) / 2, 0, 0);
        }
    }
    private static int findKthSmallestNum(int[] nums1, int[] nums2, int k, int pos1, int pos2) {
        if (k == 1) {
            return Math.min(nums1[pos1], nums2[pos2]);
        }
        int index1 = Math.min(pos1 + k / 2 - 1, nums1.length - 1),
                index2 = Math.min(pos2 + k / 2 - 1, nums2.length - 1);
        if (nums1[index1] < nums2[index2]) {
            if (index1 + 1 > nums1.length - 1) {
                return nums2[k - nums1.length + pos1 + pos2 - 1];
            }
            return findKthSmallestNum(nums1, nums2, k - (index1 + 1 - pos1), index1 + 1, pos2);
        } else {
            if (index2 + 1 > nums2.length - 1) {
                return nums1[k - nums2.length + pos2 + pos1 - 1];
            }
            return findKthSmallestNum(nums1, nums2, k - (index2 + 1 - pos2), pos1, index2 + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
//        System.out.println(mySolution(nums1, nums2));
//        System.out.println(mySolution2(nums1, nums2));
        System.out.println(findKthSmallestNum(nums1, nums2, 2, 0, 0));
    }
}
