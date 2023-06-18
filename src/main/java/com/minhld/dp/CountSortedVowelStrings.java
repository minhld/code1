package com.minhld.dp;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        for (int i = 1; i <= 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            total += dp[n][i];
        }
        return total;
    }

    /*
     * faster solution - from leetcode
     */
    public int countVowelStrings2(int n) {
        int a, e, i, o, u;
        a = e = i = o = u = 1;
        for(int t = 1; t < n; t++){
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;
    }
}
