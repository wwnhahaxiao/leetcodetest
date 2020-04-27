package com.roshan.leetcode;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring without repeating characters.
//        Example 1:
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class Test0003_LengthOfLongestSubstring {

    private static int mySolution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                len = Math.max(i - Math.max(map.get(c), left), len);
                left = Math.max(map.get(c), left);
            } else {
                len = Math.max(i - left, len);
            }
            map.put(c, i);
        }
        return len;
    }

    public static void main(String[] args) {
        String str = " ";
//      String str = "012345678901234567890123456789";
        System.out.println(mySolution(str));
    }
}
