package leetcode;

import org.junit.Test;

import java.util.Arrays;

//You are given a string s. You can convert s to a palindrome by adding characters in front of it.
//        Return the shortest palindrome you can find by performing this transformation.
//        Example 1:
//        Input: s = "aacecaaa"
//        Output: "aaacecaaa"
//        Example 2:
//        Input: s = "abcd"
//        Output: "dcbabcd"
//        Constraints:
//        0 <= s.length <= 5 * 104
//        s consists of lowercase English letters only.
public class Test0214_ShortestPalindrome {
    private String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }

    @Test
    public void test() {
        String shortest = shortestPalindrome("babbbabbaba");
        System.out.println(shortest);
    }
}
