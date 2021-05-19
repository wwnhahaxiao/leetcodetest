package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//        Example 1:
//        Input: target = 7, nums = [2,3,1,2,4,3]
//        Output: 2
//        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//        Example 2:
//        Input: target = 4, nums = [1,4,4]
//        Output: 1
//        Example 3:
//        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//        Output: 0
//        Constraints:
//        1 <= target <= 109
//        1 <= nums.length <= 105
//        1 <= nums[i] <= 105
//        Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
public class Test0209_MinimumSizeSubarraySum {
    //O(n)
    private int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = -1, sum = 0, len = 0, min = Integer.MAX_VALUE;
        while (++right < nums.length) {
            len++;
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, len);
                sum -= nums[left];
                left++;
                len--;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    //O(n log(n))
    private int minSubArrayLen1(int target, int[] nums) {
        int len = minSubArrayLen(target, nums, 0, nums.length - 1);
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    private int minSubArrayLen(int target, int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        if (left == right) {
            return nums[left] >= target ? 1 : Integer.MAX_VALUE;
        }
        int mid = (left + right) / 2;
        // 第一种情况 子串在左半部分
        int leftMin = minSubArrayLen(target, nums, left, mid - 1);
        // 第二种情况 子串在右半部分
        int rightMin = minSubArrayLen(target, nums, mid + 1, right);
        // 第三种情况 子串在中间
        int sum = 0, midMin = Integer.MAX_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum >= target) {
                midMin = Math.min(mid - i + 1, midMin);
                break;
            }
            int currentSum = sum;
            for (int j = mid + 1; j <= right; j++) {
                currentSum += nums[j];
                if (currentSum >= target) {
                    midMin = Math.min(j - i + 1, midMin);
                    break;
                }
            }
        }
        return Math.min(midMin, Math.min(leftMin, rightMin));
    }

    @Test
    public void test() {
        Map<Pair<Integer, int[]>, Integer> testMap = new HashMap<>();
        testMap.put(new Pair<>(7, new int[]{2, 3, 1, 2, 4, 3}), 2);
        testMap.put(new Pair<>(4, new int[]{1, 4, 4}), 1);
        testMap.put(new Pair<>(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), 0);
        testMap.put(new Pair<>(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}), 8);
        testMap.put(new Pair<>(15, new int[]{1, 2, 3, 4, 5}), 5);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue()
                        .equals(minSubArrayLen(entry.getKey().getKey(), entry.getKey().getValue())))
                .findAny()
                .ifPresent(System.out::println);
    }
}
