package com.roshan.leetcode;

//Given a 32-bit signed integer, reverse digits of an integer.
//        Example 1:
//        Input: 123
//        Output: 321
//        Example 2:
//        Input: -123
//        Output: -321
//        Example 3:
//        Input: 120
//        Output: 21
//        Note:
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
public class Test0007_ReverseInteger {
    public static int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE) {
            return (int) r;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
