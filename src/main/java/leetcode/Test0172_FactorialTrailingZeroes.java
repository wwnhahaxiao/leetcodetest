package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given an integer n, return the number of trailing zeroes in n!.
//        Example 1:
//        Input: 3
//        Output: 0
//        Explanation: 3! = 6, no trailing zero.
//        Example 2:
//        Input: 5
//        Output: 1
//        Explanation: 5! = 120, one trailing zero.
//        Note: Your solution should be in logarithmic time complexity.
public class Test0172_FactorialTrailingZeroes {
    /**
     * n! = 1*2*3...n-1*n
     * 首先把所有元素分解
     * n! = 1*2*3*4*5*(2*3)*7*(2*4)...n-1*n
     * 尾数0的数量=所有因子中(2*5)的数量
     * 因为2的数量>5的数量
     * 所以尾数0的数量=所有因子中5的数量
     * 5,10,15..中包含1个5, 25,50,75...中包含两个5...
     * 第1次循环 计算出n中包含多少个5的倍数
     * 第2次循环 计算出n中包含多少个25的倍数
     * 第3次循环 计算出n中包含多少个125的倍数
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result += (n = (n / 5));
        }
        return result;
    }

    @Test
    public void test() {
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(3, 0);
        testMap.put(5, 1);
        testMap.put(1808548329, 452137076);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(trailingZeroes(entry.getKey())))
                .findAny()
                .ifPresent(System.out::println);
    }
}
