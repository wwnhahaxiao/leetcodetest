package com.roshan.leetcode;

public class Test {
    public static boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int match = 0;
        while (i < sn) {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }

    public static boolean isMatchA(String s, String p) {
        int i = 0, j = 0, iStar = -1, jStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                iStar = i;
                jStar = j++;
            } else if (iStar >= 0) {
                i = ++iStar;
                j = jStar + 1;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;//去除多余星号
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        String s = "aaaab";
        String p = "***a";
        System.out.println(isMatchA(s, p));
    }
}
