package leetcode;

//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//        You have the following 3 operations permitted on a word:
//        Insert a character
//        Delete a character
//        Replace a character
//        Example 1:
//        Input: word1 = "horse", word2 = "ros"
//        Output: 3
//        Explanation:
//        horse -> rorse (replace 'h' with 'r')
//        rorse -> rose (remove 'r')
//        rose -> ros (remove 'e')
//        Example 2:
//        Input: word1 = "intention", word2 = "execution"
//        Output: 5
//        Explanation:
//        intention -> inention (remove 't')
//        inention -> enention (replace 'i' with 'e')
//        enention -> exention (replace 'n' with 'x')
//        exention -> exection (replace 'n' with 'c')
//        exection -> execution (insert 'u')
public class Test0072_EditDistance {
    private static int mySolution(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i][j - 1];
                int down = dp[i - 1][j] ;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(left + 1, Math.min(down + 1, left_down));
                } else {
                    dp[i][j] = Math.min(left + 1, Math.min(down + 1, left_down + 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(mySolution("intention", "execution"));
    }
}
