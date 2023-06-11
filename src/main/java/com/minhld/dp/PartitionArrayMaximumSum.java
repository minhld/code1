package com.minhld.dp;

public class PartitionArrayMaximumSum {
    /*
    -   1   15  7   9   2   5   10
    1   1   30  45  0   0   0   0
    15  0   16  31  46  0   0   0
    7   0   0   37  48  57  0   0
    9   0   0   0   54  63  72  0
    2   0   0   0   0   56  64  84
    5   0   0   0   0   0   68  73
    10  0   0   0   0   0   0   82
 */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] dp = new int[arr.length + 2][arr.length + 2];
        int max = 0, totalMax = 0;
        for (int i = 1; i <= arr.length; i++) {
            max = 0;
            for (int j = 1; j <= arr.length; j++) {
                if (j >= i && j < i + k && j <= arr.length) {
                    max = Math.max(max, arr[j - 1]);
                    System.out.println("max=" + max + ",dp[]=" + dp[i - 1][i - 1]);
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][i - 1] + max * (j - i + 1));
                    totalMax = Math.max(totalMax, dp[i][j]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + "\t\t");
            }
            System.out.println();
        }
        return totalMax;
    }
}
