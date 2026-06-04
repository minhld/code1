package com.minhld.dp;

public class BestTimeBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length + 1];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1] = Math.min(dp[i], prices[i]);
            max = Math.max(max, prices[i] - dp[i]);
        }
        return max;
    }
}
