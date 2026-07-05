package com.minhld.dp;

import java.util.Arrays;

public class CoinChanges extends Thread {
    public void run() {
        int[] coins = { 2 };
        int amount = 3;
        System.out.println("res= " + coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amt) {
        int maxValue = Integer.MAX_VALUE;
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, maxValue);
        dp[0] = 0;
        for (int i = 0; i < amt; i++) {
            for (int coin : coins) {
                if (coin <= amt && dp[coin] == maxValue) dp[coin] = 1;
                if (i - coin >= 0 && dp[i + 1 - coin] < maxValue) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i + 1 - coin] + 1);
                }
            }
        }
        return dp[amt] < maxValue ? dp[amt] : -1;
    }

    public static  void main(String[] args) {
        new CoinChanges().start();
    }
}
