package leetcode;

import org.junit.Test;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//        Return the minimum cuts needed for a palindrome partitioning of s.
//        Example:
//        Input: "aab"
//        Output: 1
//        Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class Test0132_PalindromePartitioningII {

    private int minCut(String s) {
        int length = s.length();
        //dp[i] 表示0-i个字符最少切割次数
        int[] dp = new int[length];
        //初始化dp,每个字符都切割的情况
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < length; i++) {
            //以i为中心重新计算dp
            for (int j = 0; j <= i && i + j < length; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                } else {
                    dp[i + j] = Math.min((i - j == 0 ? 0 : (dp[i - j - 1] + 1)), dp[i + j]);
                }
            }
            //以i和i+1为中心重新计算dp
            for (int j = 0; j <= i && i + 1 + j < length; j++) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                    break;
                } else {
                    dp[i + 1 + j] = Math.min((i - j == 0 ? 0 : (dp[i - j - 1] + 1)), dp[i + 1+ j]);
                }
            }
        }
        return dp[length - 1];
    }

    @Test
    public void test() {
        int cut = minCut("cbbbcc");
        System.out.println(cut);
    }

}
