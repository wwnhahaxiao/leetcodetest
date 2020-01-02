package com.roshan.leetcode;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Test {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                arr[i + 1 + j + 1 - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= 10) {
                arr[i - 1] += arr[i] / 10;
                arr[i] = arr[i] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = i; j < arr.length; j++) {
                    sb.append(arr[j]);
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        multiply(num1, num2);
    }
}
