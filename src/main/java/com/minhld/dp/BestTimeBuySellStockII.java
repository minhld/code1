package com.minhld.dp;

public class BestTimeBuySellStockII {
    public int maxProfit1(int[] p) {
        int n = p.length;
        int[][] dp = new int[n + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = 0;
            for (int j = i; j <= n; j++) {
                max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(max, dp[i - 1][i - 1] + p[j - 1] - p[i - 1]);
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[n][n];
    }
}
