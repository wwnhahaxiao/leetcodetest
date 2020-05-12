package leetcode;

import org.junit.Test;

import java.util.Arrays;

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
    private Integer[][] memory;
    private int[] prices;

    private int maxProfit(int[] prices) {
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
        int[] prices = {1, 2, 3, 4, 5};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    public int maxProfit2(int[] prices){
        if (prices==null || prices.length<=0) {
            return 0;
        }
        //状态定义：i代表第i天
        //j=0 什么都不做
        //j=1 第一次买入
        //j=2 第一次卖出
        //j=3 第二次买入
        //j=4 第二次卖出
        int[][] dp=new int[prices.length][5];
        int INF=Integer.MIN_VALUE,n=prices.length;
        //设置不可达状态,比如我不可能第一天就是处于第二次买入的状态,这显然是不可理的,其他的状态不能通过这个来转化
        Arrays.fill(dp[0],INF);
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=0;
            dp[i][1]=Math.max(-prices[i],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            //第i天处于第二次买入状态最大值 = max(前一天处于第一次卖出状态 今天又新买入 , 前一天处于第二次买入状态)
            dp[i][3]=Math.max(dp[i-1][2]!=INF?dp[i-1][2]-prices[i]:INF,dp[i-1][3]);
            //需要判断前一天的状态是否合法，虽然这里设置的是Integer.MIN_VALUE，但是如果不加判断会溢出，导致结果错误
            //这里可以通过设置一个合适的值来避免判断，比如0x3f3f3f3f
            dp[i][4]=Math.max(dp[i-1][3]!=INF?dp[i-1][3]+prices[i]:INF,dp[i-1][4]);
        }
        return Math.max(Math.max(dp[n-1][0],dp[n-1][2]),dp[n-1][4]);
    }
}
