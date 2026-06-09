package com.minhld.dp;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i - 1][j - 1] == 1) continue;
                else if (i == 1 && j == 1) dp[i][j] = 1;
                else if (j - 2 >= 0 && g[i - 1][j - 2] == 1) dp[i][j] = dp[i - 1][j];
                else if (i - 2 >= 0 && g[i - 2][j - 1] == 1) dp[i][j] = dp[i][j - 1];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
