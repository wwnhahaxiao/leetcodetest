package leetcode;

import org.junit.Test;

import java.util.*;

//Given an m x n board of characters and a list of strings words, return all words on the board.
//        Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//        Example 1:
//        Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
//        Output: ["eat","oath"]
//        Example 2:
//        Input: board = [["a","b"],["c","d"]], words = ["abcb"]
//        Output: []
//        Constraints:
//        m == board.length
//        n == board[i].length
//        1 <= m, n <= 12
//        board[i][j] is a lowercase English letter.
//        1 <= words.length <= 3 * 104
//        1 <= words[i].length <= 10
//        words[i] consists of lowercase English letters.
//        All the strings of words are unique.
public class Test0212_WordSearchII {
    private static Map<Character, List<int[]>> dict;

    private List<String> findWords(char[][] board, String[] words) {
        dict = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<int[]> list = dict.getOrDefault(board[i][j], new ArrayList<>());
                list.add(new int[]{i, j});
                dict.put(board[i][j], list);
            }
        }
        List<String> result = new ArrayList<>();
        for (String str : words) {
            if (dfs(str, 0, new HashMap<>(), null, null)) {
                result.add(str);
            }
        }
        return result;
    }
    private boolean dfs(String word, int index, Map<Integer, Set<Integer>> memory, Integer x, Integer y) {
        Set<Integer> set = memory.getOrDefault(x, new HashSet<>());
        memory.put(x, set);
        if (set.contains(y)) {
            return false;
        }
        if (index == word.length()) return true;
        set.add(y);
        char c = word.charAt(index);
        if (dict.containsKey(c)) {
            for (int[] arr : dict.get(c)) {
                if (x == null
                        || (arr[0] - x == 0 && Math.abs(arr[1] - y) <= 1)
                        || (Math.abs(arr[0] - x) <= 1 && arr[1] - y == 0)) {
                    if (dfs(word, index + 1, memory, arr[0], arr[1])) {
                        return true;
                    }
                }
            }
        }
        set.remove(y);
        return false;
    }

    @Test
    public void test() {
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = {{'a','a'}};
        String[] words = new String[]{"aaa"};
//        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
//        String[] words = new String[]{"dgc"};
        List<String> result = findWords(board, words);
        System.out.println(result);
    }
}
