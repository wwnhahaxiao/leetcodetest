package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//        Example 1:
//        Input: nums = [1,2,3,1], k = 3
//        Output: true
//        Example 2:
//        Input: nums = [1,0,1,1], k = 1
//        Output: true
//        Example 3:
//        Input: nums = [1,2,3,1,2,3], k = 2
//        Output: false
//        Constraints:
//        1 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//        0 <= k <= 105
public class Test0219_ContainsDuplicateII {
    private boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
