package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given two strings s and t, determine if they are isomorphic.
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//        Example 1:
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//        Input: s = "paper", t = "title"
//        Output: true
//        Note:
//        You may assume both s and t have the same length.
public class Test0205_IsomorphicStrings {
    private boolean isIsomorphic(String s, String t) {
        char[] left = s.toCharArray();
        char[] right = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < left.length; i++) {
            if (map.containsKey(left[i])) {
                if (map.get(left[i]) != right[i]) {
                    return false;
                }
            } else {
                if (set.contains(right[i])) {
                    return false;
                } else {
                    map.put(left[i], right[i]);
                    set.add(right[i]);
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        Map<Pair<String, String>, Boolean> testMap = new HashMap<>();
        testMap.put(new Pair<>("ab", "aa"), false);
        testMap.put(new Pair<>("aa", "ab"), false);
        testMap.entrySet().stream()
                .filter(entry -> isIsomorphic(entry.getKey().getKey(), entry.getKey().getValue()) != entry.getValue())
                .findAny()
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }
}
