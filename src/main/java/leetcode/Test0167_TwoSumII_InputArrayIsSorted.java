package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//        The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//        Note:
//        Your returned answers (both index1 and index2) are not zero-based.
//        You may assume that each input would have exactly one solution and you may not use the same element twice.
//        Example:
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
//        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
public class Test0167_TwoSumII_InputArrayIsSorted {
    private int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    @Test
    public void test() {
        List<Pair<Pair<int[], Integer>, int[]>> testCases = new ArrayList<>();
        testCases.add(new Pair<>(new Pair<>(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        testCases.stream()
                .filter(pair -> !Arrays.equals(pair.getValue(), twoSum(pair.getKey().getKey(), pair.getKey().getValue())))
                .findAny()
                .ifPresent(System.out::println);
    }
}
