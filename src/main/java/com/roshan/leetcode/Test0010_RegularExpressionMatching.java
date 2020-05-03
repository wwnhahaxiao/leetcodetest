package com.roshan.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//        Note:
//        s could be empty and contains only lowercase letters a-z.
//        p could be empty and contains only lowercase letters a-z, and characters like . or *.
//        Example 1:
//        Input:
//        s = "aa"
//        p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
//        Example 2:
//        Input:
//        s = "aa"
//        p = "a*"
//        Output: true
//        Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//        Example 3:
//        Input:
//        s = "ab"
//        p = ".*"
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".
//        Example 4:
//        Input:
//        s = "aab"
//        p = "c*a*b"
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//        Example 5:
//        Input:
//        s = "mississippi"
//        p = "mis*is*p*."
//        Output: false
public class Test0010_RegularExpressionMatching {

    private Boolean[][] memory;

    private boolean isMatch(String s, String p) {
        memory = new Boolean[s.length() + 1][p.length() + 1];
        return memoryMatch(s, p, 0, 0);
    }

    private boolean memoryMatch(String s, String p, int i, int j) {
        if (memory[i][j] != null) {
            return memory[i][j];
        }
        boolean result;
        if (j >= p.length()) {
            result = i == s.length();
            return result;
        }
        boolean match = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = (match && memoryMatch(s, p, i + 1, j)) || memoryMatch(s, p, i, j + 2);
        } else {
            result = match && memoryMatch(s, p, i + 1, j + 1);
        }
        memory[i][j] = result;
        return result;
    }

    @Test
    public void test() {
        Map<String[], Boolean> map = new HashMap<>();
        map.put(new String[]{"aa", "a"}, false);
        map.put(new String[]{"aa", "a*"}, true);
        map.put(new String[]{"ab", ".*"}, true);
        map.put(new String[]{"aab", "c*a*b"}, true);
        map.put(new String[]{"mississippi", "mis*is*p*."}, false);
        map.put(new String[]{"bbab", "b*a*"}, false);
        map.put(new String[]{"ab", ".*"}, true);
        map.put(new String[]{"", ".*"}, true);

        map.entrySet().stream()
                .filter(entry -> isMatch(entry.getKey()[0], entry.getKey()[1]) != entry.getValue())
                .findFirst()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey())));
    }
}
