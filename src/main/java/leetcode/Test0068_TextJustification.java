package leetcode;

import java.util.ArrayList;
import java.util.List;

//Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//        You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//        Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//        For the last line of text, it should be left justified and no extra space is inserted between words.
//        Note:
//        A word is defined as a character sequence consisting of non-space characters only.
//        Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//        The input array words contains at least one word.
//        Example 1:
//        Input:
//        words = ["This", "is", "an", "example", "of", "text", "justification."]
//        maxWidth = 16
//        Output:
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//        Example 2:
//        Input:
//        words = ["What","must","be","acknowledgment","shall","be"]
//        maxWidth = 16
//        Output:
//        [
//        "What   must   be",
//        "acknowledgment  ",
//        "shall be        "
//        ]
//        Explanation: Note that the last line is "shall be    " instead of "shall     be",
//        because the last line must be left-justified instead of fully-justified.
//        Note that the second line is also left-justified becase it contains only one word.
//        Example 3:
//        Input:
//        words = ["Science","is","what","we","understand","well","enough","to","explain",
//        "to","a","computer.","Art","is","everything","else","we","do"]
//        maxWidth = 20
//        Output:
//        [
//        "Science  is  what we",
//        "understand      well",
//        "enough to explain to",
//        "a  computer.  Art is",
//        "everything  else  we",
//        "do                  "
//        ]
public class Test0068_TextJustification {
    private static List<String> mySolution(String[] words, int maxWidth) {
        int start = 0;
        List<String> result = new ArrayList<>();

        while (start <= words.length - 1) {
            StringBuilder sb = new StringBuilder();
            int[] lineInfo = getLineInfo(words, start, maxWidth);
            if (start + lineInfo[0] != words.length) {
                for (int i = 0; i < lineInfo[0]; i++) {
                    sb.append(words[start + i]);
                    int placeHolderNum = getPlaceHolderNum(lineInfo[1], lineInfo[0], i);
                    for (int j = 0; j < placeHolderNum; j++) {
                        sb.append(" ");
                    }
                }
            } else {
                for (int i = start; i < words.length; i++) {
                    sb.append(words[i]);
                    if (i != words.length - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            start += lineInfo[0];
            result.add(sb.toString());
        }
        return result;
    }

    private static int getPlaceHolderNum(int placeHolderTotalNum, int wordNum, int wordIndex) {
        if (wordNum > 1) {
            if (wordIndex < wordNum - 1) {
                return placeHolderTotalNum / (wordNum - 1) + 1 + (placeHolderTotalNum % (wordNum - 1) > wordIndex ? 1: 0);
            } else {
                return 0;
            }
        } else {
            return placeHolderTotalNum;
        }
    }

    //return int[0]=lineWordNum int[1]=extraPlaceholderNum
    private static int[] getLineInfo(String[] words, int start, int maxWidth) {
        maxWidth -= words[start].length();
        int num = 1;
        while (start + num < words.length && maxWidth >= words[start + num].length() + 1) {
            maxWidth -= words[start + num].length() + 1;
            num++;
        }
        return new int[]{num, maxWidth};
    }

    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        List<String> list = mySolution(words, 16);
        list.forEach(System.out::println);
    }
}
