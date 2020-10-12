package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//        Example 1:
//        Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        Output: 1
//        Example 2:
//        Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        Output: 3
public class Test0200_NumberOfIslands {
    private int width = 0;
    private int height = 0;

    private int numIslands(char[][] grid) {
        int island = 0;
        width = grid.length;
        if (width == 0) {
            return 0;
        }
        height = grid[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    destroy(i, j, grid);
                }
            }
        }
        return island;
    }

    private void destroy(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        if (i + 1 < width && grid[i + 1][j] == '1') {
            destroy(i + 1, j, grid);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            destroy(i - 1, j, grid);
        }
        if (j + 1 < height && grid[i][j + 1] == '1') {
            destroy(i, j + 1, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            destroy(i, j - 1, grid);
        }
    }

    @Test
    public void test() {
        Map<char[][], Integer> testMap = new HashMap<>();
        testMap.put(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }, 1);
        testMap.put(
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }, 3);
        testMap.put(
                new char[][]{
                        {'1', '1', '1'},
                        {'0', '1', '0'},
                        {'1', '1', '1'}
                }, 1);
        testMap.put(
                new char[][]{
                        {'1', '0', '1', '1', '1'},
                        {'1', '0', '1', '0', '1'},
                        {'1', '1', '1', '0', '1'}
                }, 1);
        testMap.entrySet().stream()
                .filter(entry -> !entry.getValue().equals(numIslands(entry.getKey())))
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.deepToString(entry.getKey())));
    }
}
