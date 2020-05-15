package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Say you have an array for which the ith element is the price of a given stock on day i.
//        Design an algorithm to find the maximum profit. You may complete at most two transactions.
//        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//        Example 1:
//        Input: [3,3,5,0,0,3,1,4]
//        Output: 6
//        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//                     Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//        Example 2:
//        Input: [1,2,3,4,5]
//        Output: 4
//        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//                     Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//                     engaging multiple transactions at the same time. You must sell before buying again.
//        Example 3:
//        Input: [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transaction is done, i.e. max profit = 0.
public class Test0123_BestTimeToBuyAndSellStockIII {

    /**
     * 一次遍历,时间O(n),空间O(1)
     */
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSold = 0, secondBuy = Integer.MIN_VALUE, secondSold = 0;
        for (int price : prices) {
            firstBuy = Math.max(-price, firstBuy);
            firstSold = Math.max(firstBuy + price, firstSold);
            secondBuy = Math.max(firstSold - price, secondBuy);
            secondSold = Math.max(secondBuy + price, secondSold);
        }
        return secondSold;
    }

    /**
     * 暴力枚举,记忆优化
     */
    private Integer[][] memory;
    private int[] prices;
    private int maxProfit2(int[] prices) {
        memory = new Integer[prices.length][prices.length];
        this.prices = prices;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(getProfit(0, i) + getProfit(i + 1, prices.length - 1), profit);
        }
        return profit;
    }

    private int getProfit(int left, int right) {
        if (left > prices.length - 1) return 0;
        if (memory[left][right] != null) return memory[left][right];
        int min = Integer.MAX_VALUE, profit = 0;
        for (int i = left; i <= right; i++) {
            min = Math.min(prices[i], min);
            profit = Math.max(prices[i] - min, profit);
        }
        memory[left][right] = profit;
        return profit;
    }

    @Test
    public void test() {
        Map<int[], Integer> testMap = new HashMap<>();
        testMap.put(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6);
        testMap.put(new int[]{1, 2, 3, 4, 5},4);
        testMap.put(new int[]{7,6,4,3,1},0);
        testMap.put(new int[]{},0);
        testMap.put(new int[]{1},0);
        testMap.put(new int[]{1,2},1);
        testMap.put(new int[]{2,1},0);
        testMap.put(new int[]{3,3},0);
        testMap.put(new int[]{1,2,4},3);
        testMap.put(new int[]{1,4,2},3);
        testMap.put(new int[]{2,1,4},3);
        testMap.put(new int[]{2,4,1},2);
        testMap.put(new int[]{4,1,2},1);
        testMap.put(new int[]{4,2,1},0);
        testMap.put(new int[]{2,2,5},3);
        testMap.put(new int[]{1,1,0},0);
        testMap.put(new int[]{2,1,2,0,1},2);
        testMap.put(new int[]{3,2,6,5,0,3},7);
        testMap.put(new int[]{6,1,3,2,4,7},7);
        testMap.put(new int[]{2,1,4,5,2,9,7},11);
        testMap.put(new int[]{2,1,2,1,0,0,1},2);
        testMap.put(new int[]{2,1,2,1,0,1,2},3);
        testMap.put(new int[]{1,2,4,2,5,7,2,4,9,0},13);
        testMap.put(new int[]{1,2,4,2,5,7,2,4,9,0,9},17);
        testMap.put(new int[]{1,2,4,7},6);
        testMap.put(new int[]{1,2,7,4},6);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            List<Map.Entry<int[], Integer>> errorList = testMap.entrySet().stream()
                    .filter(entry -> maxProfit2(entry.getKey()) != entry.getValue())
                    .collect(Collectors.toList());
            errorList.forEach(System.out::print);
        }
        System.out.println(System.currentTimeMillis() - start);

    }

    /**
     * 股票类问题模板
     */
    public int maxProfitTemplate(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //dp[a][b][c]代表第a天完成b次交易(买入卖出算1次)时自己还有多少钱,c=0代表没有股票,c=1代表还有股票
        int b = 2;
        int[][][] dp = new int[prices.length][b + 1][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                //base case
                dp[i][0][0] = 0;
                dp[i][0][1] = -prices[i];
                dp[i][1][0] = Integer.MIN_VALUE;
                dp[i][1][1] = Integer.MIN_VALUE;
                dp[i][2][0] = Integer.MIN_VALUE;
                dp[i][2][1] = Integer.MIN_VALUE;
            } else {
                //任意一天没完成1次交易且没有股票时,金额为0
                dp[i][0][0] = 0;

                //任意一天没完成1次交易且有股票时,金额为:
//                    1):前一天处于0次交易并且有股票
//                    2):前一天处于0次交易没有股票,且今天买入
                dp[i][0][1] = Math.max(dp[i -1][0][1], -prices[i]);

//                第i天 完成1次交易后没有股票时,金额为:
//                    1):前一天就完成了1次交易且没有股票
//                    2):前一天处于交易0次手上有股票的状态,且今天卖出
                dp[i][1][0] = Math.max(dp[i - 1][1][0],
                        dp[i - 1][0][1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][0][1] + prices[i]);

//                第i天 完成1次交易后有股票时,金额为:
//                    1):前一天就处于该状态
//                    2):前一天完成1次交易手上没有股票,且今天买入
                dp[i][1][1] = Math.max(dp[i - 1][1][1],
                        dp[i - 1][1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][1][0] - prices[i]);

//                第i天 完成2次交易后没有股票,金额为
//                    1):前一天就处于该状态
//                    2):前一天完成一次交易有股票,且今天卖出
                dp[i][2][0] = Math.max(dp[i - 1][2][0],
                        dp[i - 1][1][1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][1][1] + prices[i]);
            }
        }
        int maxProfit = 0;
        for (int i = 0; i <= b; i++) {
            maxProfit = Math.max(maxProfit, dp[prices.length - 1][i][0]);
        }
        return maxProfit;
    }
}
