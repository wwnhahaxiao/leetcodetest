package leetcode;
//Implement pow(x, n), which calculates x raised to the power n (xn).
//        Example 1:
//        Input: 2.00000, 10
//        Output: 1024.00000
//        Example 2:
//        Input: 2.10000, 3
//        Output: 9.26100
//        Example 3:
//        Input: 2.00000, -2
//        Output: 0.25000
//        Explanation: 2-2 = 1/22 = 1/4 = 0.25
//        Note:
//        -100.0 < x < 100.0
//        n is a 32-bit signed integer, within the range [−231, 231 − 1]
public class Test0050_PowXN {
    private static double mySolution(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        return fastPow(x, power);
    }
    private static double fastPow(double x, long power) {
        if (power == 1) {
            return x;
        }
        if (power % 2 == 0) {
            return fastPow(x * x, power / 2);
        } else {
            return fastPow(x * x, power / 2) * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(mySolution(2, 10));
    }
}
