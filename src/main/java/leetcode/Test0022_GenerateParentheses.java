package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//        For example, given n = 3, a solution set is:
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
public class Test0022_GenerateParentheses {

    private static List<String> officialSolutionOne(int n) {
        char[] str = new char[n * 2];
        List<String> list = new ArrayList<>();
        generate(str, 0, list);
        return list;
    }

    private static void generate(char[] str, int index, List<String> result) {
        if (index == str.length) {
            if (check(str)) {
                result.add(new String(str));
            }
        } else {
            str[index] = '(';
            generate(str, index + 1, result);
            str[index] = ')';
            generate(str, index + 1, result);
        }
    }

    private static boolean check(char[] str) {
        int num = 0;
        for (char c : str) {
            if (c == '(') {
                num++;
            } else if (c == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        return num == 0;
    }

    public static void main(String[] args) {
        int size = 5;
        long l = System.currentTimeMillis();
//        myRecursiveSolution(size);
        long l1 = System.currentTimeMillis();
        System.out.println("recursiveSolution duration: " + (l1 - l));
//        List<String> one = officialSolutionOne(size);
        long l2 = System.currentTimeMillis();
        System.out.println("mySolution duration: " + (l2 - l1));
        List<String> three = officialSolutionThree(size);
        three.forEach(System.out::println);

    }

    private static List<String> myRecursiveSolution(int n) {
        LinkedList<String> temp = new LinkedList<>();
        temp.add("");
        while (temp.peek().length() < n * 2) {
            String pop = temp.pop();
            String case1 = pop + "(";
            if (checkValid(case1, false)) {
                temp.add(case1);
            }
            String case2 = pop + ")";
            if (checkValid(case2, false)) {
                temp.add(case2);
            }
        }
        List<String> result = new ArrayList<>();
        for (String res : temp) {
            if (checkValid(res, true)) {
                result.add(res);
            }
        }
        return result;
    }
    private static boolean checkValid(String s, boolean lastCheck) {
        int pair = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                pair++;
            } else {
                pair--;
                if (pair < 0) {
                    return false;
                }
            }
        }
        if (lastCheck && pair != 0) {
            return false;
        }
        return true;
    }
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList();
//        backtrack(ans, "", 0, 0, n);
//        return ans;
//    }
//
//    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
//        if (cur.length() == max * 2) {
//            ans.add(cur);
//            return;
//        }
//
//        if (open < max) {
//            backtrack(ans, cur + "(", open + 1, close, max);
//        }
//        if (close < open) {
//            backtrack(ans, cur + ")", open, close + 1, max);
//        }
//    }


    private static List<String> officialSolutionThree(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : officialSolutionThree(c)) {
                    for (String right : officialSolutionThree(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
}
