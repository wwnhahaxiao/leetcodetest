package leetcode;

import org.junit.Test;

//Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//        Note:
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//        Example 1:
//        Input: [2,2,3,2]
//        Output: 3
//        Example 2:
//        Input: [0,1,0,1,0,1,99]
//        Output: 99
public class Test0137_SingleNumberII {

    private int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    @Test
    public void test() {
//        int[] nums = {2,2,3,2};
        int[] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        int number = singleNumber(nums);
        System.out.println(number);
    }
}
