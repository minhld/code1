package com.minhld.dp;

public class UniquePaths extends Thread {
    public void run() {
        System.out.println("run = " + uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = i == 1 && j == 1 ? 1 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new UniquePaths().start();
    }
}
