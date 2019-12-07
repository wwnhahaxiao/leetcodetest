package com.roshan.leetcode;

public class Test0011_ContainerWithMostWater {
    public static int mySolution(int[] height) {
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length - i; j++) {
                water = Math.max(water, j * Math.min(height[i],height[i + j]));
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(mySolution(test));
        System.out.println(maxArea(test));
        System.out.println(maxArea1(test));
    }

    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    /**
     * 先取宽度最大,然后两端较短的一边向内移动(长度相同时随便移动哪条,因为宽度变小的情况下移动较长的一边并不会扩大面积)
     */
    public static int maxArea1(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
}
