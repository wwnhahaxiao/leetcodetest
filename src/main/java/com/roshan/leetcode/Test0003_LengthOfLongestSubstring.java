package com.roshan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test0003_LengthOfLongestSubstring {

    private static int mySolution(String s) {
        Map<Character, Integer> map = new HashMap();
        int max = 0, len = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                len = Math.max(map.get(s.charAt(i)), len);
            }
            max = Math.max(i - len + 1, max);
            map.put(s.charAt(i), i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcdasdfasdghadhifofhasdbfjkabjh";
//      String str = "012345678901234567890123456789";
        System.out.println(mySolution(str));
        System.out.println(lengthOfLongestSubstring(str));
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                len = Math.max(map.get(c), len);
            }
            ans = Math.max(ans, i - len + 1);
            map.put(c, i + 1);
        }
        return ans;
    }

}
