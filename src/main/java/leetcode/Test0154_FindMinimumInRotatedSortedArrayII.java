package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//        Find the minimum element.
//        The array may contain duplicates.
//        Example 1:
//        Input: [1,3,5]
//        Output: 1
//        Example 2:
//        Input: [2,2,2,0,1]
//        Output: 0
//        Note:
//        This is a follow up problem to Find Minimum in Rotated Sorted Array.
//        Would allow duplicates affect the run-time complexity? How and why?
public class Test0154_FindMinimumInRotatedSortedArrayII {
    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right -= 1;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{3, 1, 1}, 1);
        testMap.put(new int[]{3, 3, 1, 3}, 1);
        testMap.put(new int[]{2, 2, 2, 0, 1}, 0);
        testMap.put(new int[]{1, 3, 3}, 1);
        testMap.put(new int[]{1, 3, 5}, 1);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(findMin(entry.getKey())))
                .findAny()
                .ifPresent(entry -> {
                    List<Integer> list = Arrays.stream(entry.getKey()).boxed().collect(Collectors.toList());
                    System.out.println(list + "=" + entry.getValue());
                });
    }
}
