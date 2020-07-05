package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//        You may assume that the array is non-empty and the majority element always exist in the array.
//        Example 1:
//        Input: [3,2,3]
//        Output: 3
//        Example 2:
//        Input: [2,2,1,1,1,2,2]
//        Output: 2
public class Test0169_MajorityElement {
    private int majorityElement(int[] nums) {
        int currValue = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                currValue = n;
            }
            if (n == currValue) {
                count++;
            } else {
                count--;
            }
        }
        return currValue;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        int i = majorityElement(nums);
        System.out.println(i);
    }
}
