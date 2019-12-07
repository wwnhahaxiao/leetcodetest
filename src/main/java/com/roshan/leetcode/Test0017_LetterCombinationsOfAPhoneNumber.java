package com.roshan.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//        Example:
//        Input: "23"
//        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//        Note:
//        Although the above answer is in lexicographical order, your answer could be in any order you want.
public class Test0017_LetterCombinationsOfAPhoneNumber {
    private static List<String> mySolution(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() < i + 1) {
                String head = list.remove();
                for (char c : mapping[index].toCharArray()) {
                    list.add(head + c);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> theirs = mySolution("23");
        theirs.forEach(System.out::println);
    }
}
