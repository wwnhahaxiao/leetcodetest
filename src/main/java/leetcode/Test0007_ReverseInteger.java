package leetcode;

//Given a 32-bit signed integer, reverse digits of an integer.
//        Example 1:
//        Input: 123
//        Output: 321
//        Example 2:
//        Input: -123
//        Output: -321
//        Example 3:
//        Input: 120
//        Output: 21
//        Note:
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
public class Test0007_ReverseInteger {
    private static int mySolution(int x) {
        int result = 0;
        while (x != 0) {
            int i = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && i > 7)
                    || result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && i < -8)) {
                return 0;
            }
            result = result * 10 + i;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(123));
    }
}
