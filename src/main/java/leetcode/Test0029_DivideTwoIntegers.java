package leetcode;

//Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
//        Return the quotient after dividing dividend by divisor.
//        The integer division should truncate toward zero.
//        Example 1:
//        Input: dividend = 10, divisor = 3
//        Output: 3
//        Example 2:
//        Input: dividend = 7, divisor = -3
//        Output: -2
//        Note:
//        Both dividend and divisor will be 32-bit signed integers.
//        The divisor will never be 0.
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
public class Test0029_DivideTwoIntegers {
    private static int mySolution(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int result = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int res = -1;
            while (temp << 1 >= dividend && temp >= Integer.MIN_VALUE >> 1) {
                temp = temp << 1;
                res = res << 1;
            }
            result += res;
            dividend -= temp;
        }
        if (!sign) {
            if (result == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(mySolution(2147483647, 3));
    }
}
