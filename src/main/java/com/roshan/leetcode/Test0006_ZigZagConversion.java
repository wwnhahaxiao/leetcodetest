package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test0006_ZigZagConversion {
    private static String mySolution2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int row = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += row) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && row - i + j < s.length()) {
                    sb.append(s.charAt(row - i + j));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String s = mySolution2(str, 3);
        System.out.println(s);
    }
}
