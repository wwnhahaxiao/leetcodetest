package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//        If the fractional part is repeating, enclose the repeating part in parentheses.
//        Example 1:
//        Input: numerator = 1, denominator = 2
//        Output: "0.5"
//        Example 2:
//        Input: numerator = 2, denominator = 1
//        Output: "2"
//        Example 3:
//        Input: numerator = 2, denominator = 3
//        Output: "0.(6)"
public class Test0166_FractionToRecurringDecimal {

    private String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> indexMap = new HashMap<>();
        long a = numerator, b = denominator;
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            sb.append("-");
            a = -a;
        }
        sb.append(a / b);
        a = a % b;
        if (a == 0) {
            return sb.toString();
        }
        a *= 10;
        sb.append(".");

        int index = sb.length();
        while (!indexMap.containsKey(a)) {
            indexMap.put(a, index++);
            sb.append(a / b);
            a = a % b;
            if (a == 0) {
                return sb.toString();
            }
            a *= 10;
        }
        int duplicateIndex = indexMap.get(a);
        sb.insert(duplicateIndex, "(");
        sb.append(")");
        return sb.toString();
    }

    @Test
    public void test() {
        int numerator = -1;
        int denominator = -2147483648;
        String s = fractionToDecimal(numerator, denominator);
        System.out.println(s);
    }
}
