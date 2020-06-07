package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//There are N children standing in a line. Each child is assigned a rating value.
//        You are giving candies to these children subjected to the following requirements:
//        Each child must have at least one candy.
//        Children with a higher rating get more candies than their neighbors.
//        What is the minimum candies you must give?
//        Example 1:
//        Input: [1,0,2]
//        Output: 5
//        Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//        Example 2:
//        Input: [1,2,2]
//        Output: 4
//        Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//        The third child gets 1 candy because it satisfies the above two conditions.
public class Test0135_Candy {
    private int candy(int[] ratings) {
        int candies = 1, direction = 0, up = 0, down = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newDirection = Integer.compare(ratings[i], ratings[i - 1]);
            //分数相同或者分数到达最低时为一轮 计算之前所有学生的糖果
            if (newDirection == 0 || (newDirection > 0 && newDirection != direction)) {
                candies += sum(up) + sum(down) + Math.max(up, down);
                up = down = 0;
            }
            if (newDirection > 0) {
                up++;
            } else if (newDirection == 0) {
                candies++;
            } else {
                down++;
            }
            direction = newDirection;
        }
        return candies + sum(up) + sum(down) + Math.max(up, down);
    }

    private int sum(int n) {
        return (n + 1) * n / 2;
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{3,2,1,2,3}, 11);
        testMap.put(new int[]{1,0,2}, 5);
        testMap.put(new int[]{1,2,3,1,0}, 9);
        testMap.put(new int[]{1,6,10,8,7,3,2}, 18);
        testMap.put(new int[]{1,3,2,2,1}, 7);
        testMap.put(new int[]{1,3,4,5,2}, 11);
        testMap.put(new int[]{1,2,3,1,0}, 9);
        testMap.put(new int[]{1,2,87,87,87,2,1}, 13);
        testMap.entrySet().stream()
                .filter(entry -> candy(entry.getKey()) != entry.getValue())
                .findFirst()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey()) + ":" + entry.getValue()));
    }

}
