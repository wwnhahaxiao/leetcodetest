package com.roshan.leetcode;

import java.util.*;

//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//        The replacement must be in-place and use only constant extra memory.
//        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1
public class Test0031_NextPermutation {
    private static void mySolution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        int index = nums.length - 1;
        int changeIndex = -1;
        while (index > 0 && changeIndex == -1) {
            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next > nums[index]) {
                    nums[index] = next;
                    changeIndex = index;
                    iterator.remove();
                    break;
                }
            }
            index--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == changeIndex) {
                continue;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        mySolution(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
