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
    private int maxProfit2(int k, int[] prices) {
        int[] mostProfit = new int[k];
        int start = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                int profit = prices[i - 1] - prices[start];
                insert(mostProfit, profit);
            }
        }
        return Arrays.stream(mostProfit).sum();
    }

    private void insert(int[] profits, int profit) {
        for (int i = 0; i < profits.length; i++) {
            if (profits[i] > profit) {
                profits[i] = profit;
            } else {
                profits[i] = profits[i + 1];
            }
        }
    }
    private int maxProfit(int k, int[] prices) {
        int[] money = new int[2 * k];
        Arrays.fill(money, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = 0; j < money.length && j <= i; j++) {
                if (j % 2 == 0) {
                    int pre = j == 0 ? 0 : money[j - 1];
                    money[j] = Math.max(pre - price, money[j]);
                } else {
                    money[j] = Math.max(money[j - 1] + price, money[j]);
                }
            }
        }
        int result = 0;
        for (int profit : money) {
            result = Math.max(profit, result);
        }
        return result;
    }

    @Test
    public void test() {
        Map<Pair<int[], Integer>, Integer> testMap = new HashMap<>();
        testMap.put(new Pair<>(new int[]{2,4,1}, 2), 2);
//        testMap.put(new Pair<>(new int[]{3,2,6,5,0,3}, 2), 7);
        testMap.entrySet().stream()
                .filter(entry -> maxProfit2(entry.getKey().getValue(), entry.getKey().getKey()) != entry.getValue())
                .findAny()
                .ifPresent(entry -> System.out.println(Arrays.toString(entry.getKey().getKey())));
    }
}
