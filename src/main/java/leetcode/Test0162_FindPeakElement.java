package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//A peak element is an element that is greater than its neighbors.
//        Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//        You may imagine that nums[-1] = nums[n] = -∞.
//        Example 1:
//        Input: nums = [1,2,3,1]
//        Output: 2
//        Explanation: 3 is a peak element and your function should return the index number 2.
//        Example 2:
//        Input: nums = [1,2,1,3,5,6,4]
//        Output: 1 or 5
//        Explanation: Your function can return either index number 1 where the peak element is 2,
//                     or index number 5 where the peak element is 6.
//        Follow up: Your solution should be in logarithmic complexity.
public class Test0162_FindPeakElement {
    private int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        Map<int[], int[]> testMap = new HashMap<>();
        testMap.put(new int[]{1, 2, 3, 1}, new int[]{2});
        testMap.put(new int[]{1, 2}, new int[]{1});
        testMap.put(new int[]{2, 1, 2}, new int[]{0, 2});
        testMap.put(new int[]{1, 2, 1, 3, 5, 6, 4}, new int[]{1, 5});
        testMap.forEach((key, value) -> {
            int peekIndex = findPeakElement(key);
            boolean match = Arrays.stream(value)
                    .anyMatch(i -> i == peekIndex);
            if (!match) {
                System.out.println(Arrays.toString(key) + Arrays.toString(value) + ",result: " + peekIndex);
            }
        });
    }
}
