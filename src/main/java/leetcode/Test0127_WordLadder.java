package leetcode;

import org.junit.Test;

import java.util.*;

//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//        Only one letter can be changed at a time.
//        Each transformed word must exist in the word list.
//        Note:
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Example 1:
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//        Output: 5
//        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//        Example 2:
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//        Output: 0
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
public class Test0127_WordLadder {
    private Set<String> memory;
    private Map<String, List<String>> dictionary;
    private Integer len;
    private String endWord;

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        this.endWord = endWord;
        this.len = beginWord.length();
        this.memory = new HashSet<>();
        this.dictionary = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> originWords = dictionary.getOrDefault(newWord, new ArrayList<>());
                originWords.add(word);
                dictionary.put(newWord, originWords);
            }
        });
        Map<String, Integer> beginLevel = Collections.singletonMap(beginWord, 1);
        Map<String, Integer> endLevel = Collections.singletonMap(endWord, 1);
        return transform(beginLevel, endLevel);
    }

    private int transform(Map<String, Integer> beginLevel, Map<String, Integer> endLevel) {
        Map<String, Integer> nextBeginLevel = new HashMap<>();
        Map<String, Integer> nextEndLevel = new HashMap<>();
        //正向
        for (Map.Entry<String, Integer> entry : beginLevel.entrySet()) {
            String word = entry.getKey();
            for (int i = 0; i < len; i++) {
                String transformation = word.substring(0, i) + "*" + word.substring(i + 1);
                if (dictionary.containsKey(transformation)) {
                    for (String origin : dictionary.get(transformation)) {
                        if (endLevel.containsKey(origin)) {
                            return entry.getValue() + endLevel.get(origin);
                        }
                        if (!memory.contains(origin)) {
                            nextBeginLevel.put(origin, entry.getValue() + 1);
                        }
                    }
                }
            }
        }
        if (nextBeginLevel.isEmpty()) {
            return 0;
        }
        //逆向
        for (Map.Entry<String, Integer> entry : endLevel.entrySet()) {
            String word = entry.getKey();
            for (int i = 0; i < len; i++) {
                String transformation = word.substring(0, i) + "*" + word.substring(i + 1);
                if (dictionary.containsKey(transformation)) {
                    for (String origin : dictionary.get(transformation)) {
                        if (nextBeginLevel.containsKey(origin)) {
                            return entry.getValue() + nextBeginLevel.get(origin);
                        }
                        if (!memory.contains(origin)) {
                            nextEndLevel.put(origin, entry.getValue() + 1);
                        }
                    }
                }
            }
        }
        if (nextEndLevel.isEmpty()) {
            return 0;
        }
        memory.addAll(nextBeginLevel.keySet());
        memory.addAll(nextEndLevel.keySet());
        return transform(nextBeginLevel, nextEndLevel);
    }

    @Test
    public void test() {
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dog");
//        String beginWord = "hit", endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }
}
