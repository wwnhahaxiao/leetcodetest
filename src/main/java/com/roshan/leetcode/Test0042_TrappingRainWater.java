package com.roshan.leetcode;
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//        Example 1:
//        Input: num1 = "2", num2 = "3"
//        Output: "6"
//        Example 2:
//        Input: num1 = "123", num2 = "456"
//        Output: "56088"
//        Note:
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contain only digits 0-9.
//        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class Test0042_TrappingRainWater {
    private static int mySoluton(int[] height) {
        //第一次遍历寻找最后一个最高的柱子
        int highest = 0;
        int highIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= highest) {
                highest = height[i];
                highIndex = i;
            }
        }
        int water = 0;
        int i = 0;
        int high = 0;
        while (i < highIndex) {
            if (height[i] > high) {
                high = height[i];
            } else if (height[i] < high) {
                water += high - height[i];
            }
            i++;
        }
        i = height.length - 1;
        high = 0;
        while (i > highIndex) {
            if (height[i] > high) {
                high = height[i];
            } else if (height[i] < high) {
                water += high - height[i];
            }
            i--;
        }
        return water;
    }
}
