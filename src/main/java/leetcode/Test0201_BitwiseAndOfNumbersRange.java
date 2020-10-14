package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//        Example 1:
//        Input: [5,7]
//        Output: 4
//        Example 2:
//        Input: [0,1]
//        Output: 0
public class Test0201_BitwiseAndOfNumbersRange {
    private int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{5, 7}, 4);
        testMap.put(new int[]{0, 1}, 0);
        testMap.put(new int[]{4, 6}, 4);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(rangeBitwiseAnd(entry.getKey()[0], entry.getKey()[1])))
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey())));
    }
}
