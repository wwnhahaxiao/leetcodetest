package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array, rotate the array to the right by k steps, where k is non-negative.
//        Follow up:
//        Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//        Could you do it in-place with O(1) extra space?
//        Example 1:
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]
//        Example 2:
//        Input: nums = [-1,-100,3,99], k = 2
//        Output: [3,99,-1,-100]
//        Explanation:
//        rotate 1 steps to the right: [99,-1,-100,3]
//        rotate 2 steps to the right: [3,99,-1,-100]
//        Constraints:
//        1 <= nums.length <= 2 * 10^4
//        It's guaranteed that nums[i] fits in a 32 bit-signed integer.
//        k >= 0
public class Test0189_RotateArray {
    private void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    @Test
    public void test() {
        Map<Pair<int[], Integer>, int[]> testMap = new HashMap<>();
        testMap.put(new Pair<>(new int[]{1, 2, 3, 4, 5, 6, 7}, 3), new int[]{5, 6, 7, 1, 2, 3, 4});
        testMap.put(new Pair<>(new int[]{-1, -100, 3, 99}, 2), new int[]{3, 99, -1, -100});
        testMap.put(new Pair<>(new int[]{1, 2}, 3), new int[]{2, 1});
        testMap.entrySet().stream()
                .filter(entry -> {
                    rotate(entry.getKey().getKey(), entry.getKey().getValue());
                    if (Arrays.equals(entry.getKey().getKey(), entry.getValue())) {
                        return false;
                    }
                    return true;
                }).findAny()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getValue())));
    }

}
