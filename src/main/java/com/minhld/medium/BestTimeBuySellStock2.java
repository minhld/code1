package com.minhld.medium;

public class BestTimeBuySellStock2 extends Thread {
    public void run() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("res = " + maxProfit(prices));
    }

    /**
     * greedy version beats 100%
     * @param p
     * @return
     */
    public int maxProfit2(int[] p) {
        int profit = 0;
        for (int i = 1; i < p.length; i++) {
            profit += Math.max(0, p[i] - p[i - 1]);
        }
        return profit;
    }

    public int maxProfit(int[] p) {
        int n = p.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + Math.max(0, p[i] - p[j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new BestTimeBuySellStock2().start();
    }
}
