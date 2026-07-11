package com.minhld.dp;

import java.util.Arrays;

public class CoinChangesII extends Thread {
    public void run() {
        int[] coins = { 1,2,5 };
        int amount = 5;
        System.out.println("res= " + change(amount, coins));
    }

    public int change(int amt, int[] coins) {
        int[] dp = new int[amt + 1];
        for (int i = 0; i < amt; i++) {
            for (int coin : coins) {
                if (dp[coin] == 0) dp[coin] = 1;
                if (i >= coin) {
                    dp[i + 1] += dp[i + 1 - coin] * dp[coin];
                }
            }
        }
        return dp[amt];
    }

    public static  void main(String[] args) {
        new CoinChangesII().start();
    }
}
