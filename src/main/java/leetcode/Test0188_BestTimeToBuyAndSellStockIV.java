package leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Say you have an array for which the i-th element is the price of a given stock on day i.
//        Design an algorithm to find the maximum profit. You may complete at most k transactions.
//        Note:
//        You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//        Example 1:
//        Input: [2,4,1], k = 2
//        Output: 2
//        Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
//        Example 2:
//        Input: [3,2,6,5,0,3], k = 2
//        Output: 7
//        Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
//                     Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
public class Test0188_BestTimeToBuyAndSellStockIV {
    private int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        //当k过大时转化为无限次交易
        if (k >= prices.length / 2) {
            int buy = -prices[0], sold = 0;
            for (int price : prices) {
                buy = Math.max(sold - price, buy);
                sold = Math.max(buy + price, sold);
            }
            return sold;
        }
        //int[i][j]代表第i次交易j=0买入j=1卖出后剩余钱数
        int[][] profits = new int[k][2];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    profits[j][0] = -price;
                } else {
                    profits[j][0] = Math.max((j > 0 ? profits[j - 1][1] : 0) - price, profits[j][0]);
                    profits[j][1] = Math.max(profits[j][0] + price, profits[j][1]);
                }
            }
        }
        return profits[k - 1][1];
    }

    @Test
    public void test() {
        Map<Pair<int[], Integer>, Integer> testMap = new HashMap<>();
        testMap.put(new Pair<>(new int[]{1,3}, 0), 0);
        testMap.put(new Pair<>(new int[]{2,4,1}, 2), 2);
        testMap.put(new Pair<>(new int[]{3,2,6,5,0,3}, 2), 7);
        testMap.entrySet().stream()
                .filter(entry -> maxProfit(entry.getKey().getValue(), entry.getKey().getKey()) != entry.getValue())
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey().getKey())));
    }
}
