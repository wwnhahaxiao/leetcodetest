package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Reverse bits of a given 32 bits unsigned integer.
//        Example 1:
//        Input: 00000010100101000001111010011100
//        Output: 00111001011110000010100101000000
//        Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
//        Example 2:
//        Input: 11111111111111111111111111111101
//        Output: 10111111111111111111111111111111
//        Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
//        Note:
//        Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
//        In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
//        Follow up:
//        If this function is called many times, how would you optimize it?
//        Constraints:
//        The input must be a binary string of length = 32
public class Test0190_ReverseBits {
    // you need treat n as an unsigned value
    private int reverseBits(int n) {
        //将数字分为两半 颠倒左右16位
        n = (n >>> 16) | (n << 16);
        //将两半的数字再分为两份 并颠倒
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    @Test
    public void test() {
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(43261596, 964176192);
//        testMap.put(Integer.valueOf("11111111111111111111111111111101", 2), 964176192);
        testMap.entrySet().stream()
                .filter(entry -> entry.getValue() != reverseBits(entry.getKey()))
                .findAny()
                .ifPresent(System.out::println);
    }
}
