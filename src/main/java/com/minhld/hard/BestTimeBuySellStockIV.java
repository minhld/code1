package com.minhld.hard;

import java.util.Arrays;

public class BestTimeBuySellStockIV extends Thread {
    public void run() {
//        int[] prices = {1,2,6,5,4,3,4,5,1,7};
        int[] prices = {6,1,3,2,4,7};
//        int[] prices = { 3,2,6,5,0,3 };
        int k = 2;
        System.out.println("res = " + maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] p) {
        int n = p.length;
        Stock[] dp = new Stock[n + 1];
        Arrays.setAll(dp, i -> new Stock(k + 1));

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
        new BestTimeBuySellStockIV().start();
    }
}
