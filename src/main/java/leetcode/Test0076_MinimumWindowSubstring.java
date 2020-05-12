package leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//        Example:
//        Input: S = "ADOBECODEBANC", T = "ABC"
//        Output: "BANC"
//        Note:
//        If there is no such window in S that covers all characters in T, return the empty string "".
//        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
public class Test0076_MinimumWindowSubstring {
    private static String mySolution(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, length = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                continue;
            }
            map.computeIfPresent(c, (k, v) -> v - 1);
            if (map.values().stream().max(Comparator.comparingInt(o -> o)).get() <= 0) {
                while (left <= i) {
                    char leftStr = s.charAt(left);
                    if (map.containsKey(leftStr) && map.get(leftStr) < 0) {
                        map.computeIfPresent(leftStr, (k, v) -> v + 1);
                    } else if (map.containsKey(leftStr) && map.get(leftStr) >= 0) {
                        if (i - left < length) {
                            length = i - left;
                            result = s.substring(left, i + 1);
                        }
                        break;
                    }
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String[], String> map = new HashMap<>();
        map.put(new String[]{"ADOBECODEBANC","ABC"}, "BANC");
        map.put(new String[]{"abcabdebac","cda"}, "cabd");
        map.entrySet().stream()
                .filter(entry -> !mySolution(entry.getKey()[0], entry.getKey()[1]).equals(entry.getValue()))
                .findFirst()
                .ifPresent(entry -> System.out.println("failed: " + Arrays.toString(entry.getKey())));
        System.out.println("done");
    }
}
