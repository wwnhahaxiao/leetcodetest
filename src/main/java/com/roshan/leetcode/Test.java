package com.roshan.leetcode;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        Arrays.sort(arr,1,3);
        System.out.print("321: ");
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.print("321: ");
        int[] ar = {3,2,1};
        Arrays.sort(ar);
        for (int i : ar) {
            System.out.print(i);
        }
        System.out.println();
    }
}
