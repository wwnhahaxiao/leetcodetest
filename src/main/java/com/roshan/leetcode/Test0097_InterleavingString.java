package com.roshan.leetcode;

import java.util.Arrays;

//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//        Example 1:
//        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//        Output: true
//        Example 2:
//        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//        Output: false
public class Test0097_InterleavingString {
    private static char[] c1,c2,c3;
    private static int[][] checked;

    private static boolean mySolution(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        checked = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : checked) {
            Arrays.fill(arr, -1);
        }
        return match(0, 0, 0);
    }
    private static boolean match(int p1, int p2, int p3) {
        if (p3 == c3.length) {
            return true;
        }
        if (checked[p1][p2] >= 0) {
            return checked[p1][p2] == 1;
        }
        if (p1 < c1.length && c3[p3] == c1[p1] && match(p1 + 1, p2, p3 + 1)) {
            checked[p1][p2] = 1;
            return true;
        }
        if (p2 < c2.length && c3[p3] == c2[p2] && match(p1, p2 + 1, p3 + 1)) {
            checked[p1][p2] = 1;
            return true;
        }
        checked[p1][p2] = 0;
        return false;
    }

    public static void main(String[] args) {
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        System.out.println(mySolution(s1, s2, s3));
    }

    private static boolean mySolution2(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                            || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
