package leetcode;

import java.util.Arrays;

//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//        Example:
//        Given array nums = [-1, 2, 1, -4], and target = 1.
//        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Test0016_3SumClosest {
    private static int mySolution(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                } else if (sum < target) {
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else {
                    return sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] test = new int[]{-1, 2, 1, -4};
        int[] test = new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        int target = -52;
        System.out.println(mySolution(test, target));
    }
}
