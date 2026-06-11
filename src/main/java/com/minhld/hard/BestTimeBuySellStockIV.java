package com.minhld.hard;

import java.util.Arrays;

public class BestTimeBuySellStockIV extends Thread{
    public void run() {
        int[] prices = {1,2,6,5,4,3,4,5,1,7};
        int k = 2;
        System.out.println("res = " + maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Stock[][] dp = new Stock[n + 1][n + 1];
        for (Stock[] row : dp) {
            Arrays.setAll(row, i -> new Stock(0, 0));
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i || prices[i] - prices[j] <= 0) {
                    dp[i + 1][j + 1] = dp[j + 1][j + 1];
                } else if (prices[i] - prices[j] > 0) {
                    dp[i + 1][j + 1] = new Stock(dp[i][j + 1].p + dp[j][j].p + prices[i] - prices[j], dp[i][j + 1].t + 1);
                }
                if (dp[i + 1][j + 1].t <= k) {
                    max = Math.max(max, dp[i + 1][j + 1].p);
                }
            }
        }

        return max;
    }


    public static class Stock {
        int p;  // total profit
        int t;  // times
        public Stock(int p, int t) {
            this.p = p;
            this.t = t;
        }

        @Override
        public String toString() {
            return this.p + ":" + this.t;
        }
    }

    public static void main(String[] args) {
        new BestTimeBuySellStockIV().start();
    }
}
