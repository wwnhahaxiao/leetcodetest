package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//        Example 1:
//        Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//                     Total amount you can rob = 1 + 3 = 4.
//        Example 2:
//        Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//                     Total amount you can rob = 2 + 9 + 1 = 12.
//        Constraints:
//        0 <= nums.length <= 100
//        0 <= nums[i] <= 400
public class Test0198_HouseRobber {
    private int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int current = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(pre + nums[i], current);
            pre = current;
            current = temp;
        }
        return current;
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{1, 2, 3, 1}, 4);
        testMap.put(new int[]{2, 7, 9, 3, 1}, 12);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(rob(entry.getKey())))
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey())));
    }
}
