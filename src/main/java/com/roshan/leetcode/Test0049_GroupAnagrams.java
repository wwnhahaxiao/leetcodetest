package com.roshan.leetcode;

import java.util.*;
import java.util.stream.Collectors;

//Given an array of strings, group anagrams together.
//        Example:
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//        All inputs will be in lowercase.
//        The order of your output does not matter.
public class Test0049_GroupAnagrams {
    private static List<List<String>> mySolution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = mySolution(strs);
        System.out.println(lists);
    }
}
