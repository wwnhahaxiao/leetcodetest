package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test0006_ZigZagConversion {
    public static String mySolution(String s, int numRows) {
        List<List<String>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<String> row = new ArrayList<>();
            rows.add(row);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int n = getNum(i, numRows);
            rows.get(n - 1).add(String.valueOf(chars[i]));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            sb.append(rows.get(i));
        }
        return sb.toString();
    }

    private static int getNum(int i, int rows) {
        i++;
        int num = i % (2 * rows - 2);
        int result;
        if (num > rows) {
            result = rows - (num - rows);
        } else {
            result = num;
        }
        if (result == 0) {
            return 2;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("asdhjafkasdhkfjans;dfihjasdkljfahd;slfasdfhjasdkfhjaklsdkfkl;akjds;fajsdkfak;jhdtgwe4uiapijdfk");
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        s.append(s);
        long t1 = System.currentTimeMillis();
        mySolution(s.toString(), 4);
        long t2 = System.currentTimeMillis();
        convert(s.toString(), 4);
        long t3 = System.currentTimeMillis();
        convert1(s.toString(), 4);
        long t4 = System.currentTimeMillis();
        System.out.println("mine:" + (t2 - t1));
        System.out.println("s1:" + (t3 - t2));
        System.out.println("s2:" + (t4 - t3));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static String convert1(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }
}
