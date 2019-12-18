package com.roshan.leetcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", null);
        Integer integer = map.getOrDefault("1", 1);
        System.out.println(integer);
    }
}
