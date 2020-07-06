package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given a column title as appear in an Excel sheet, return its corresponding column number.
//        For example:
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28
//        ...
//        Example 1:
//        Input: "A"
//        Output: 1
//        Example 2:
//        Input: "AB"
//        Output: 28
//        Example 3:
//        Input: "ZY"
//        Output: 701
//        Constraints:
//        1 <= s.length <= 7
//        s consists only of uppercase English letters.
//        s is between "A" and "FXSHRXW".
public class Test0171_ExcelSheetColumnNumber {
    private int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    @Test
    public void test() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("A", 1);
        testMap.put("AB", 28);
        testMap.put("ZY", 701);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(titleToNumber(entry.getKey())))
                .findAny()
                .ifPresent(System.out::println);
    }
}
