package com.minhld.dp;

public class DeleteOperationTwoStrings {
    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length() + 2][w2.length() + 2];
        int max = 0, inc;
        for (int i = 1; i <= w1.length(); i++) {
            for (int j = 1; j <= w2.length(); j++) {
                inc = w1.charAt(i - 1) == w2.charAt(j - 1) ? 1 : 0;
                dp[i][j] = Math.max(dp[i - 1][j - 1] + inc, Math.max(dp[i][j - 1], dp[i - 1][j]));
                if (max < dp[i][j]) max = dp[i][j];
            }
        }
        return w1.length() + w2.length() - 2 * max;
    }
}
