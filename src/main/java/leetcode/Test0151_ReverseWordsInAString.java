package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//    Given an input string, reverse the string word by word.
//    Example 1:
//    Input: "the sky is blue"
//    Output: "blue is sky the"
//    Example 2:
//    Input: "  hello world!  "
//    Output: "world! hello"
//    Explanation: Your reversed string should not contain leading or trailing spaces.
//    Example 3:
//    Input: "a good   example"
//    Output: "example good a"
//    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//    Note:
//    A word is defined as a sequence of non-space characters.
//    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
//    You need to reduce multiple spaces between two words to a single space in the reversed string.
public class Test0151_ReverseWordsInAString {
    private String reverseWords(String s) {
        LinkedList<String> buffer = new LinkedList<>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isSpaceChar(s.charAt(i))) {
                if (start != -1) {
                    buffer.addFirst(s.substring(start, i));
                    start = -1;
                }
            } else if (start == -1) {
                start = i;
            }
        }
        if (start != -1) {
            buffer.addFirst(s.substring(start));
        }
        return String.join(" ", buffer);
    }
    @Test
    public void test() {
        List<Pair<String, String>> testCases = new ArrayList<>();
        testCases.add(new Pair<>("", ""));
        testCases.add(new Pair<>("the sky is blue", "blue is sky the"));
        testCases.add(new Pair<>("  hello world!  ", "world! hello"));
        testCases.add(new Pair<>("a good   example", "example good a"));
        testCases.stream()
                .filter(pair -> !pair.getValue().equals(reverseWords(pair.getKey())))
                .findAny()
                .ifPresent(pair -> System.out.println(pair + "-->" + reverseWords(pair.getKey())));
    }
}
