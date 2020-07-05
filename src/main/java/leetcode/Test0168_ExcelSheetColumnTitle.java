package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//        For example:
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
//        ...
//        Example 1:
//        Input: 1
//        Output: "A"
//        Example 2:
//        Input: 28
//        Output: "AB"
//        Example 3:
//        Input: 701
//        Output: "ZY"
public class Test0168_ExcelSheetColumnTitle {
    private String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int i = n % 26;
            if (i == 0) {
                i = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + i - 1));
            n /= 26;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "A");
        testMap.put(26, "Z");
        testMap.put(28, "AB");
        testMap.put(701, "ZY");
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(convertToTitle(entry.getKey())))
                .findAny()
                .ifPresent(System.out::println);
    }
}
