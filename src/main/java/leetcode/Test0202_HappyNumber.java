package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Write an algorithm to determine if a number n is "happy".
//        A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//        Return True if n is a happy number, and False if not.
//        Example: 
//        Input: 19
//        Output: true
//        Explanation:
//        12 + 92 = 82
//        82 + 22 = 68
//        62 + 82 = 100
//        12 + 02 + 02 = 1
public class Test0202_HappyNumber {
    private boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int result = 0;
        while (n > 9) {
            int index = n % 10;
            result += index * index;
            n = n / 10;
        }
        return n * n + result;
    }

    @Test
    public void test() {
        Map<Integer, Boolean> testMap = new HashMap<>();
        testMap.put(19, true);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(isHappy(entry.getKey())))
                .findAny()
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }
}
