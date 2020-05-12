package leetcode;

//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//        Example 1:
//        Input: "(()"
//        Output: 2
//        Explanation: The longest valid parentheses substring is "()"
//        Example 2:
//        Input: ")()())"
//        Output: 4
//        Explanation: The longest valid parentheses substring is "()()"
public class Test0032_LongestValidParentheses {
    private static int mySolution(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(left * 2, max);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(left * 2, max);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(mySolution(s));
    }
}
