package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//        The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//        Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//        In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//        Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
//        For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
//        -2 (K)	-3	3
//        -5	-10	1
//        10	30	-5 (P)
//        Note:
//        The knight's health has no upper bound.
//        Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
public class Test0174_DungeonGame {
    private int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length - 1;
        int width = dungeon[0].length - 1;
        //修改过的dungeon[i][j]表示到该位置只要还有多少血量就可以顺利到终点
        //方便计算 血量使用负数 dungeon[height][width] = -3表示到终点还剩3血即可通关
        dungeon[height][width] = Math.min(dungeon[height][width] - 1, -1);
        //计算最右一列所需血量
        for (int i = height - 1; i >= 0; i--) {
            dungeon[i][width] = Math.min(dungeon[i][width] + dungeon[i + 1][width], -1);
        }
        //计算最下一行所需血量
        for(int i = width - 1; i >= 0; i--) {
            dungeon[height][i] = Math.min(dungeon[height][i] + dungeon[height][i + 1], -1);
        }
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                dungeon[i][j] = Math.min(Math.max(dungeon[i + 1][j], dungeon[i][j + 1]) + dungeon[i][j], -1);
            }
        }
        return -dungeon[0][0];
    }

    @Test
    public void test() {
        Map<int[][], Integer> testMap = new HashMap<>();
        testMap.put(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}, 7);
        testMap.put(new int[][]{{100}}, 1);
        testMap.put(new int[][]{{0},{0}}, 1);
        testMap.put(new int[][]{{0, 0, 0}, {1, 1, -1}}, 1);
        testMap.put(new int[][]{{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}}, 3);
        testMap.put(new int[][]{{1, -2, 3}, {2, -2, -2}}, 2);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(calculateMinimumHP(entry.getKey())))
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.deepToString(entry.getKey())));
    }
}
