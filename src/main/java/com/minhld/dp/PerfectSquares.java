package com.minhld.dp;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int min, sqn;
        for (int i = 1; i <= n; i++) {
            min = n;
            sqn = (int) Math.sqrt(i);
            for (int j = 1; j <= sqn; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = 1 + min;
        }
        return dp[n];
    }
}
