package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//        Below is one possible representation of s1 = "great":
//        great
//        /    \
//        gr    eat
//        / \    /  \
//        g   r  e   at
//        / \
//        a   t
//        To scramble the string, we may choose any non-leaf node and swap its two children.
//        For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//        rgeat
//        /    \
//        rg    eat
//        / \    /  \
//        r   g  e   at
//        / \
//        a   t
//        We say that "rgeat" is a scrambled string of "great".
//        Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//        rgtae
//        /    \
//        rg    tae
//        / \    /  \
//        r   g  ta  e
//        / \
//        t   a
//        We say that "rgtae" is a scrambled string of "great".
//        Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
//        Example 1:
//        Input: s1 = "great", s2 = "rgeat"
//        Output: true
//        Example 2:
//        Input: s1 = "abcde", s2 = "caebd"
//        Output: false
public class Test0087_ScrambleString {
    private static boolean mySolution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        for (int i = 1; i < len; i++) {
            boolean flag = (mySolution(s1.substring(0, i), s2.substring(0, i))
                    && mySolution(s1.substring(i), s2.substring(i)))
                    || (mySolution(s1.substring(0, i), s2.substring(len - i))
                    && mySolution(s1.substring(i), s2.substring(0, len - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(mySolution(s1, s2));
        //todo use my struct solve
    }

    private static class MyTree {
        private MyTree brother = null;
        private List<MyTree> children;
        private MyTree parent = null;
        private String content;

        public MyTree(String str) {
            this.content = str;
            if (str.length() > 1) {
                this.children = new ArrayList<>();
                int mid = str.length() / 2;
                MyTree leftChild = new MyTree(str.substring(0, mid));
                MyTree rightChild = new MyTree(str.substring(mid));
                children.add(leftChild);
                children.add(rightChild);
                leftChild.brother = rightChild;
                leftChild.parent = this;
                rightChild.brother = leftChild;
                rightChild.parent = this;
            }
        }

        private boolean contain(char c) {
            if (content.length() == 1)  {
                return content.toCharArray()[0] == c;
            } else {
                if (children == null) {
                    return false;
                }
                for (MyTree child : children) {
                    if (child.contain(c)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private MyTree find(char c) {
            if (content.length() == 1) {
                if (content.toCharArray()[0] == c) {
                    return this;
                } else {
                    return null;
                }
            } else {
                for (MyTree child : children) {
                    if (child.find(c) != null) {
                        return child.find(c);
                    }
                }
                return null;
            }
        }

        public MyTree getBrother() {
            return brother;
        }

        public void setBrother(MyTree brother) {
            this.brother = brother;
        }

        public List<MyTree> getChildren() {
            return children;
        }

        public void setChildren(List<MyTree> children) {
            this.children = children;
        }

        public MyTree getParent() {
            return parent;
        }

        public void setParent(MyTree parent) {
            this.parent = parent;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
