package com.roshan.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Test0115_DistinctSubsequences {
    private int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    @Test
    public void test() {
        String s = "babgbag", t = "bag";
        int i = numDistinct(s, t);
        System.out.println(i);
    }
}
