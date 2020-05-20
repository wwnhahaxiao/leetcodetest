package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//        Only one letter can be changed at a time
//        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//        Note:
//        Return an empty list if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Example 1:
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//        Output:
//        [
//        ["hit","hot","dot","dog","cog"],
//          ["hit","hot","lot","log","cog"]
//        ]
//        Example 2:
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//        Output: []
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
public class Test0126_WordLadderII {

    //bfs
    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> dictionary = new HashMap<>();
        //初始化字典
        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> originWords = dictionary.getOrDefault(newWord, new ArrayList<>());
                originWords.add(word);
                dictionary.put(newWord, originWords);
            }
        });
        //构造队列初始化数据
        Queue<Pair<String, List<String>>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, new ArrayList<>(Collections.singletonList(beginWord))));
        Set<String> memory = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        //是否找到结果标识,找到结果后处理完当前队列后停止,下一次轮询的结果必然长度比当前结果长度大
        boolean finish = false;
        while (!queue.isEmpty() && !finish) {
            int size = queue.size();
            Set<String> tempMemory = new HashSet<>();
            for (int i = 0; i < size; i++) {
                Pair<String, List<String>> node = queue.remove();
                String word = node.getKey();
                List<String> traces = node.getValue();
                for (int j = 0; j < len; j++) {
                    String newWord = word.substring(0, j) + '*' + word.substring(j + 1);
                    for (String originWord : dictionary.getOrDefault(newWord, new ArrayList<>())) {
                        //memory缓存之前每轮队列轮询时扫描过的word
                        if (!memory.contains(originWord)) {
                            traces.add(originWord);
                            if (originWord.equals(endWord)) {
                                result.add(new ArrayList<>(traces));
                                finish = true;
                            }
                            tempMemory.add(originWord);
                            queue.add(new Pair<>(originWord, new ArrayList<>(traces)));
                            traces.remove(traces.size() - 1);
                        }
                    }
                }
            }
            memory.addAll(tempMemory);
        }
        return result;
    }

    @Test
    public void test() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log", "cog"});
        List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }
}
