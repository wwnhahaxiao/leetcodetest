package com.roshan.leetcode;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        Given a non-empty string containing only digits, determine the total number of ways to decode it.
//        Example 1:
//        Input: "12"
//        Output: 2
//        Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//        Example 2:
//        Input: "226"
//        Output: 3
//        Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
public class Test0091_DecodeWays {
    private static int mySolution(String s) {
        int curr = Character.getNumericValue(s.charAt(0));
        if (curr == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int first = 1, second = 1;
        for (int i = 1; i < s.length(); i++) {
            int result;
            int pre = curr;
            curr = Character.getNumericValue(s.charAt(i));
            if (curr == 0) {
                if (pre == 0 || pre > 2) {
                    return 0;
                }
                result = first;
            } else {
                if (pre == 1 || (pre == 2 && curr <= 6)) {
                    result = first + second;
                } else {
                    result = second;
                }
            }
            first = second;
            second = result;
        }
        return second;
    }

    public static void main(String[] args) {
        String s = "12120";
        System.out.println(mySolution(s));
    }
}
