package com.minhld.dp;

import java.util.Arrays;

public class CoinChangesII extends Thread {
    public void run() {
        int[] coins = { 1,2,5 };
        int amount = 7;
        System.out.println("res= " + change(amount, coins));
    }

    // 7 / 1 % 0 -> 1
    // 7 / 2 = 3 -> 3
    // 7 / 5 = 1 -> 2

    //6/1 ->1
    //6/2 ->3
    //6/5 ->1

    //7/1 ->1
    //7/2 ->3
    //7/5 ->1 + 1

    //5=5           d[5]
    //5=2+2+1       d[2]
    //5=2+1+1+1
    //5=1+1+1+1+1   d[1][]

    //6=5+1         d[5]
    //6=2+2+2       d[4]
    //6=2+2+1+1
    //6=2+1+1+1+1
    //6=1+1+1+1+1+1 d[1]

    //7=5+2           d[2] 2
    //7=5+1+1
    //7=2+2+2+1       d[5] 4    -> 3
    //7=2+2+1+1+1
    //7=2+1+1+1+1+1
    //7=1+1+1+1+1+1+1 d[6] 5    -> 5

    //12=5+5+2              d[7][] +
    //12=5+5+1+1            d[10][2], d[11]
    //12=5+2+2+2+1          2 + d[10] 6
    //12=5+2+2+1+1+1        1 + d[11] 1
    //12=5+2+1+1+1+1+1
    //12=5+1+1+1+1+1+1+1

    //8=5+2+1           d[8][5] = d[3][2]
    //8=5+1+1+1
    //8=2+2+2+2         d[8][2] = d[6][2]
    //8=2+2+2+1+1       d[6] - d[5]
    //8=2+2+1+1+1+1
    //8=2+1+1+1+1+1+1
    //8=1+1+1+1+1+1+1+1 d[8][1]
    //d[8] = d[3]2 + d[6] - (4)... + d[7](1)

    public int change(int m, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return  dp[n][m];
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

    // m = 1,


    public static  void main(String[] args) {
        new CoinChangesII().start();
    }
}
