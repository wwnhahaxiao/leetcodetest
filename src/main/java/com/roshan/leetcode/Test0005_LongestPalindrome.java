package com.roshan.leetcode;
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//        Example 1:
//        Input: "babad"
//        Output: "bab"
//        Note: "aba" is also a valid answer.
//        Example 2:
//        Input: "cbbd"
//        Output: "bb"
public class Test0005_LongestPalindrome {
    private static char[] arr;
    private static String mySolution(String s) {
        if (s.isEmpty()) {
            return s;
        }
        arr = s.toCharArray();
        int length = 0, start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = palindromeLength(i, i);
            if (len > length) {
                start = i - len / 2;
                end = i + len / 2;
                length = len;
            }
            int len1 = palindromeLength(i, i + 1);
            if (len1 > length) {
                start = i - len1 / 2 + 1;
                end = i + len1 / 2;
                length = len1;
            }
        }
        return s.substring(start, end + 1);
    }
    private static int palindromeLength(int left, int right) {
        while (left >= 0 && right <= arr.length - 1 && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
//        String str = "babad";
        String str = "tattarrattat";
        String s = mySolution(str);
        System.out.println(s);
    }
}
