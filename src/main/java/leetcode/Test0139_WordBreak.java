package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//        Note:
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//        Input: s = "leetcode", wordDict = ["leet", "code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//        Example 2:
//        Input: s = "applepenapple", wordDict = ["apple", "pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//                     Note that you are allowed to reuse a dictionary word.
//        Example 3:
//        Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//        Output: false
public class Test0139_WordBreak {
    private String s;
    private Set<String> dict;
    private boolean[] memory;

    private boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.dict = new HashSet<>(wordDict);
        this.memory = new boolean[s.length()];
        Arrays.fill(memory, true);
        return backtrack(0);
    }

    private boolean backtrack(int start) {
        if (start == s.length()) return true;
        if (!memory[start]) {
            return false;
        }
        for (int i = 1; start + i <= s.length(); i++) {
            if (dict.contains(s.substring(start, start + i))) {
                if (backtrack(start + i)) {
                    return true;
                }
            }
        }
        memory[start] = false;
        return false;
    }

    @Test
    public void test() {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        boolean b = wordBreak(s, dict);
        System.out.println(b);
    }
}
