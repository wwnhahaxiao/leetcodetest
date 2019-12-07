package com.roshan.leetcode;

import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test0151_ReverseWordsInAString {
    //    Given an input string, reverse the string word by word.
//    Example 1:
//    Input: "the sky is blue"
//    Output: "blue is sky the"
//    Example 2:
//    Input: "  hello world!  "
//    Output: "world! hello"
//    Explanation: Your reversed string should not contain leading or trailing spaces.
//    Example 3:
//    Input: "a good   example"
//    Output: "example good a"
//    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//    Note:
//    A word is defined as a sequence of non-space characters.
//    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
//    You need to reduce multiple spaces between two words to a single space in the reversed string.
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c)) {
                if (sb.length() > 0) {
                    res.insert(0, sb.toString() + " ");
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            res.insert(0, sb.toString() + " ");
        }
        return res.toString().substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }
}
