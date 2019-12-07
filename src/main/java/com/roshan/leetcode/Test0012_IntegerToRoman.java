package com.roshan.leetcode;

public class Test0012_IntegerToRoman {
    private static String intToRoman(int num) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
        String[] romanUnits = new String[]{"M", "C", "X", "I"};
        int[] intUnits = new int[]{1000, 100, 10, 1};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < intUnits.length; i++) {
            int unit = intUnits[i];
            int unitNum = num / unit;
            if (unitNum >= 5) {

            } else {

            }
            for (int j = 0; j < unitNum; j++) {
                sb.append(romanUnits[i]);
            }

            num = num % unit;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4055));
    }
}
