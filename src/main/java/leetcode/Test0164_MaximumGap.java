package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//        Return 0 if the array contains less than 2 elements.
//        Example 1:
//        Input: [3,6,9,1]
//        Output: 3
//        Explanation: The sorted form of the array is [1,3,6,9], either
//                     (3,6) or (6,9) has the maximum difference 3.
//        Example 2:
//        Input: [10]
//        Output: 0
//        Explanation: The array contains less than 2 elements, therefore return 0.
//        Note:
//        You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
//        Try to solve it in linear time/space.
public class Test0164_MaximumGap {
    private int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        //获取数组最大值max,最小值min
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, gap;
        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        //如果数组排序后 num[i] - num[i - 1]相同 最大间隙为gap
        gap = (int) Math.ceil((max - min) / (nums.length - 1d));
        Integer[][] buckets = new Integer[nums.length][2];

        for (int n : nums) {
            //计算n在哪个bucket内
            int index = (int) Math.ceil((n - min) / (double) gap);
            //bucket[0]记录该桶内最小值,bucket[1]记录该桶内最大值
            if (buckets[index][0] == null) {
                buckets[index][0] = n;
            } else {
                buckets[index][0] = Math.min(n, buckets[index][0]);
            }
            if (buckets[index][1] == null) {
                buckets[index][1] = n;
            } else {
                buckets[index][1] = Math.max(n, buckets[index][1]);
            }
        }
        //比较两个桶之间的距离
        int result = 0;
        Integer pre = null;
        for (Integer[] bucket : buckets) {
            if (bucket[0] == null) continue;
            if (pre != null) {
                result = Math.max(bucket[0] - pre, result);
            }
            pre = bucket[1];
        }
        return result;
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{1,1,1,1}, 0);
        testMap.put(new int[]{3,6,9,1}, 3);
        testMap.put(new int[]{100,3,2,1}, 97);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(maximumGap(entry.getKey())))
                .findAny()
                .ifPresent(entry -> System.out.println(entry));
    }

}
