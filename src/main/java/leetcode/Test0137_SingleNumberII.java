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

    private int singleNumber2(int[] nums) {
        int[] countArr = new int[32];
        for (int num : nums) {
            String s = Integer.toBinaryString(num);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    countArr[32 - s.length() + i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : countArr) {
            sb.append(i % 3);
        }
        System.out.println(sb.toString());
        return 0;
    }
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
        int[] nums = {5,2,2,2,3,3,3};
        int number = singleNumber2(nums);
        System.out.println(number);
    }
}
