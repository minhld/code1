package com.minhld.dp;

import java.util.Arrays;

public class MinimumCostForTickets extends Thread {
    public void run() {
        int[] days = { 1,4,6,7,8,20 };
        int[] costs = { 2,7,15 };
//        int[] costs = { 7,2,15 };
        System.out.println("res = " + mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int m = days[days.length - 1], n = costs.length;
        int[] pass = { 1, 7, 30 };
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int c = 0, l = 0;
        for (int i = 0; i <= m; i++) {
            if (i < days[c]) {
                dp[i] = dp[l];
                continue;
            }
            for (int j = 0; j < n; j++) {
                dp[i] = Math.min(dp[i], (days[c] >= pass[j] ? dp[days[c] - pass[j]] : 0) + costs[j]);
                l = i;
            }
            c++;
        }
        return dp[m];
    }

    public static void main(String[] args) {
        new MinimumCostForTickets().start();
    }
}
