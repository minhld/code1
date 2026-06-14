package com.minhld.hard;

import java.util.Arrays;

public class BestTimeBuySellStock3 extends Thread{
    public void run() {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("res = " + maxProfit(prices));
    }

    public int maxProfit(int[] p) {
        int n = p.length;
        int k = 2;
        BestTimeBuySellStockIV.Stock[] dp = new BestTimeBuySellStockIV.Stock[n + 1];
        Arrays.setAll(dp, i -> new BestTimeBuySellStockIV.Stock(k + 1));

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int profit = p[i] - p[j];
                if (profit <= 0) {
                    dp[i + 1].s = Arrays.copyOf(dp[j + 1].s, k + 1);
                    max = Math.max(max, Arrays.stream(dp[i + 1].s).max().orElse(0));
                } else {
                    for (int l = Math.min(k, i); l > 0; l--) {
                        if (l > 1 && dp[j].s[l - 1] == 0) continue;
                        dp[i + 1].s[l] = Math.max(dp[i + 1].s[l], dp[j].s[l - 1] + profit);
                        max = Math.max(max, dp[i + 1].s[l]);
                    }
                }
            }
        }
        return max;
    }

    public static class Stock {
        int[] s;
        public Stock(int k) {
            this.s = new int[k];
        }
    }

    public static void main(String[] args) {
        new BestTimeBuySellStock3().start();
    }
}
