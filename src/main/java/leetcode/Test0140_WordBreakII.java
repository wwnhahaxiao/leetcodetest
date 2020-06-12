package leetcode;

import org.junit.Test;

import java.util.*;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
//        Note:
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//        Input:
//        s = "catsanddog"
//        wordDict = ["cat", "cats", "and", "sand", "dog"]
//        Output:
//        [
//          "cats and dog",
//          "cat sand dog"
//        ]
//        Example 2:
//        Input:
//        s = "pineapplepenapple"
//        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//        Output:
//        [
//          "pine apple pen apple",
//          "pineapple pen apple",
//          "pine applepen apple"
//        ]
//        Explanation: Note that you are allowed to reuse a dictionary word.
//        Example 3:
//        Input:
//        s = "catsandog"
//        wordDict = ["cats", "dog", "sand", "and", "cat"]
//        Output:
//        []
public class Test0140_WordBreakII {
    private String s;
    private Set<String> dict;
    private Map<String, List<String>> memory;
    private List<String> result;

    private List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.dict = new HashSet<>(wordDict);
        this.memory = new HashMap<>();
        this.result = new ArrayList<>();
        backtrack(0, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, List<String> words) {
        if (start == s.length()) {
            result.add(String.join(" ", words));
            return;
        }
        for (int i = 1; start + i <= s.length(); i++) {
            String word = s.substring(start, start + i);
            if (dict.contains(word)) {
                words.add(word);
                backtrack(start + i, words);
                words.remove(words.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
//        String s = "leetcode";
//        List<String> dict = Arrays.asList("leet", "code");
        List<String> list = wordBreak(s, dict);
        System.out.println(list);
    }
}
