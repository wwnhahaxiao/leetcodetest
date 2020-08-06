package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of non negative integers, arrange them such that they form the largest number.
//        Example 1:
//        Input: [10,2]
//        Output: "210"
//        Example 2:
//        Input: [3,30,34,5,9]
//        Output: "9534330"
//        Note: The result may be very large, so you need to return a string instead of an integer.
public class Test0179_LargestNumber {
    private String largestNumber(int[] nums) {
        String str = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());
        for (char c : str.toCharArray()) {
            if (c != '0') {
                return str;
            }
        }
        return "0";
    }

    @Test
    public void test() {
        Map<int[], String> testMap = new HashMap<>();
        testMap.put(new int[]{10, 2}, "210");
        testMap.put(new int[]{128, 12}, "12812");
        testMap.put(new int[]{121, 12}, "12121");
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(largestNumber(entry.getKey())))
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey())));
    }
}
