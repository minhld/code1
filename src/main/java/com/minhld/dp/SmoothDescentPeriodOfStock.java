package com.minhld.dp;

public class SmoothDescentPeriodOfStock {
    public long getDescentPeriods(int[] p) {
        int n = p.length, s = 0, i = 0, j = 0;
        long[] dp = new long[n + 1];
        while (i < n) {
            dp[i + 1] = dp[i] + 1;
            s = i;
            j = i + 1;
            while (j < n) {
                if (p[j] - p[j - 1] == -1) {
                    dp[j + 1] = dp[j] + (j - s + 1);
                    i = j++;
                } else break;
            }
            i++;
        }
        return dp[n];
    }
}
