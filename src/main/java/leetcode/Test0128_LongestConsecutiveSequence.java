package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//        Your algorithm should run in O(n) complexity.
//        Example:
//        Input: [100, 4, 200, 1, 3, 2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class Test0128_LongestConsecutiveSequence {
    private int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int curr = n;
                int len = 1;
                while (set.contains(++curr)) {
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int len = longestConsecutive(nums);
        System.out.println(len);
    }
}
