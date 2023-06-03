package com.minhld.dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length() + 2][t2.length() + 2];
        int max = 0, inc = 0;
        for (int i = 1; i <= t1.length(); i++) {
            for (int j = 1; j <= t2.length(); j++) {
                inc = t1.charAt(i - 1) == t2.charAt(j - 1) ? 1 : 0;
                dp[i][j] = Math.max(dp[i - 1][j - 1] + inc, Math.max(dp[i][j - 1], dp[i - 1][j]));
                if (max < dp[i][j]) max = dp[i][j];
            }
        }
        return max;
    }
}
