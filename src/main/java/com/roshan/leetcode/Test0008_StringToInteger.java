package com.roshan.leetcode;

//Implement atoi which converts a string to an integer.
//        The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//        The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//        If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//        If no valid conversion could be performed, a zero value is returned.
//        Note:
//        Only the space character ' ' is considered as whitespace character.
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//        Example 1:
//        Input: "42"
//        Output: 42
//        Example 2:
//        Input: "   -42"
//        Output: -42
//        Explanation: The first non-whitespace character is '-', which is the minus sign.
//        Then take as many numerical digits as possible, which gets 42.
//        Example 3:
//        Input: "4193 with words"
//        Output: 4193
//        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//        Example 4:
//        Input: "words and 987"
//        Output: 0
//        Explanation: The first non-whitespace character is 'w', which is not a numerical
//        digit or a +/- sign. Therefore no valid conversion could be performed.
//        Example 5:
//        Input: "-91283472332"
//        Output: -2147483648
//        Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//        Thefore INT_MIN (−231) is returned.
public class Test0008_StringToInteger {
    private static int mySolution(String str) {
        str = str.trim();
        int sign = 1, index = 0, res = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            index++;
        }
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                int n = str.charAt(index) - '0';
                /*
                校验加正数是否超出int范围
                xxx <= Integer.MAX_VALUE
                --> xx <= (Integer.MAX_VALUE-x) / 10
                --> if (xx > (Integer.MAX_VALUE-x) / 10) 超出范围
                (sign > 0 ? 0 : 1) 兼容判断负数 负数绝对值范围比正数大1
                 */
                if (res > (Integer.MAX_VALUE - n) / 10) {
                    return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + n;
                index++;
            } else {
                break;
            }
        }
        return res * sign;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("42"));
        System.out.println(mySolution("   -42"));
        System.out.println(mySolution("4193 with words"));
        System.out.println(mySolution("words and 987"));
        System.out.println(mySolution("-91283472332"));
        System.out.println(mySolution("-2147483648"));
    }
}
