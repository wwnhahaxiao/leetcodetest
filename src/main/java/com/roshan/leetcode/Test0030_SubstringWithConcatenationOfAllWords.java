package com.roshan.leetcode;

import java.util.*;

//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//        Example 1:
//        Input:
//        s = "barfoothefoobarman",
//        words = ["foo","bar"]
//        Output: [0,9]
//        Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
//        The output order does not matter, returning [9,0] is fine too.
//        Example 2:
//        Input:
//        s = "wordgoodgoodgoodbestword",
//        words = ["word","good","best","word"]
//        Output: []
public class Test0030_SubstringWithConcatenationOfAllWords {
    //没有mySolution2效率高 方法相同mySolution2优化了部分逻辑
    private static List<Integer> mySolution(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int singleWordLength = words[0].length();
        int len = words.length * singleWordLength;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String str : words) {
            Integer num = wordMap.getOrDefault(str, 0);
            wordMap.put(str, num + 1);
        }
        int start = 0;
        while (start <= s.length() - len) {
            int end = start + len;
            Map<String, Integer> tempMap = new HashMap<>();
            int begin = start;
            while (begin <= end - singleWordLength) {
                String word = s.substring(begin, begin + singleWordLength);
                if (wordMap.containsKey(word)) {
                    Integer num = tempMap.getOrDefault(word, 0);
                    if (num + 1 > wordMap.get(word)) {
                        break;
                    }
                    tempMap.put(word, num + 1);
                } else {
                    break;
                }
                begin += singleWordLength;
            }
            if (begin == end) {
                result.add(start);
            }
            start++;
        }
        return result;
    }


    private static List<Integer> mySolution2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        int singleWordLength = words[0].length();
        int len = words.length * singleWordLength;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String str : words) {
            Integer num = wordMap.getOrDefault(str, 0);
            wordMap.put(str, num + 1);
        }
        for (int i = 0; i < singleWordLength; i++) {
            int start = i;
            Map<String, Integer> temp = new HashMap<>();
            LinkedList<String> matched = new LinkedList<>();
            while (start <= s.length() - len + singleWordLength * matched.size()) {
                String sub = s.substring(start, start + singleWordLength);
                if (wordMap.containsKey(sub)) {
                    Integer num = temp.getOrDefault(sub, 0);
                    temp.put(sub, num + 1);
                    matched.add(sub);
                    //字串包含的相同的word比words中的word数量多 start跳转到第一个word结束的位置
                    if (num + 1 > wordMap.get(sub)) {
                        start += singleWordLength;
                        while (true) {
                            String remove = matched.removeFirst();
                            temp.put(remove, temp.get(remove) - 1);
                            if (remove.equals(sub)) {
                                break;
                            }
                        }
                        continue;
                    }
                } else {
                    start += singleWordLength;
                    matched.clear();
                    temp.clear();
                    continue;
                }
                start += singleWordLength;
                if (matched.size() == words.length) {
                    result.add(start - len);
                    String remove = matched.removeFirst();
                    temp.put(remove, temp.get(remove) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> list = mySolution2(s, words);
        list.forEach(System.out::println);
    }
}
