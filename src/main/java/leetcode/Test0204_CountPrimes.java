package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

//Count the number of prime numbers less than a non-negative number, n.
//        Example 1:
//        Input: n = 10
//        Output: 4
//        Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//        Example 2:
//        Input: n = 0
//        Output: 0
//        Example 3:
//        Input: n = 1
//        Output: 0
//        Constraints:
//        0 <= n <= 5 * 10^6
public class Test0204_CountPrimes {
    private int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrimeNumber = new boolean[n];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrimeNumber[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimeNumber[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean b : isPrimeNumber) {
            if (b) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countPrimes(1500000));
//        System.out.println(countPrimes(3));
//        System.out.println(countPrimes(2));
        if (1==1)return;

        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(10, 4);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(countPrimes(entry.getKey())))
                .findAny()
                .ifPresent(System.out::println);
    }
}
