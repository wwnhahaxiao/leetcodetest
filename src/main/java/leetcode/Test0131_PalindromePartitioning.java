package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//        Return all possible palindrome partitioning of s.
//        Example:
//        Input: "aab"
//        Output:
//        [
//        ["aa","b"],
//        ["a","a","b"]
//        ]
public class Test0131_PalindromePartitioning {
    private char[] arr;
    private String s;
    private List<List<String>> result;

    private List<List<String>> partition(String s) {
        this.s = s;
        this.result = new ArrayList<>();
        arr = s.toCharArray();
        backtrack(new LinkedList<>(), 0);
        return result;
    }

    private void backtrack(LinkedList<String> palindromes, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(palindromes));
            return;
        }
        int right = start;
        while (right < arr.length) {
            if (isPalindrome(start, right++)) {
                palindromes.add(s.substring(start, right));
                backtrack(palindromes, right);
                palindromes.removeLast();
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (arr[left++] != arr[right--]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        List<List<String>> partition = partition("");
        System.out.println(partition);
    }
}
