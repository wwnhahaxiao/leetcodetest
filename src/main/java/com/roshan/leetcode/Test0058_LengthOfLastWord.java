package com.roshan.leetcode;

import java.util.HashMap;
import java.util.Map;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
//        If the last word does not exist, return 0.
//        Note: A word is defined as a maximal substring consisting of non-space characters only.
//        Example:
//        Input: "Hello World"
//        Output: 5
public class Test0058_LengthOfLastWord {
    private static int mySolution(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Hello World", 5);
        for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
            if (!entry.getValue().equals(mySolution(entry.getKey()))) {
                System.out.println("failed: " + entry.getKey());
                break;
            }
        }
        System.out.println("done");
    }
}
