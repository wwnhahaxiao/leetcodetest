package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
//        Example 1:
//        Input: "()"
//        Output: true
//        Example 2:
//        Input: "()[]{}"
//        Output: true
//        Example 3:
//        Input: "(]"
//        Output: false
//        Example 4:
//        Input: "([)]"
//        Output: false
//        Example 5:
//        Input: "{[]}"
//        Output: true
public class Test0020_ValidParentheses {

    private static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    private static boolean mySolution(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!map.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(""));
    }
}
