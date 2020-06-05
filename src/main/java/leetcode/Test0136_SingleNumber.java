package leetcode;

import org.junit.Test;

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//        Note:
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//        Example 1:
//        Input: [2,2,1]
//        Output: 1
//        Example 2:
//        Input: [4,1,2,1,2]
//        Output: 4
public class Test0136_SingleNumber {
    private int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1,2,2,3,3};
        int number = singleNumber(nums);
        System.out.println(number);
    }
}
