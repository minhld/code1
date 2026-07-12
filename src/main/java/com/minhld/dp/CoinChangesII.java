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
        dp[0] = 1;
        for (int i = 1; i <= amt; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amt];
    }

    /*
    public int change(int amount, int[] coins) {
        return change(coins, coins.length, amount);
    }

    int change(int S[], int m, int n) {
        if (n == 0) return 1;   // 1 coin selected

        // no solution exists
        if (n < 0) return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return change(S, m - 1, n) + change(S, m, n - S[m-1]);
    }
    */

    public static  void main(String[] args) {
        new CoinChangesII().start();
    }
}
