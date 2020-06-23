package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//        Find the minimum element.
//        You may assume no duplicate exists in the array.
//        Example 1:
//        Input: [3,4,5,1,2]
//        Output: 1
//        Example 2:
//        Input: [4,5,6,7,0,1,2]
//        Output: 0
public class Test0153_FindMinimumInRotatedSortedArray {
    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{3, 4, 5, 1, 2}, 1);
        testMap.put(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        testMap.put(new int[]{1, 2, 3}, 1);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(findMin(entry.getKey())))
                .findAny()
                .ifPresent(entry -> {
                    List<Integer> list = Arrays.stream(entry.getKey()).boxed().collect(Collectors.toList());
                    System.out.println(list + "=" + entry.getValue());
                });
    }
}
