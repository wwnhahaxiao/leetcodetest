package com.roshan.leetcode;

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//        Example 1:
//        Input: 121
//        Output: true
//        Example 2:
//        Input: -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//        Example 3:
//        Input: 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
public class Test0009_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int left = 0, right = str.length() - 1 - left;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
