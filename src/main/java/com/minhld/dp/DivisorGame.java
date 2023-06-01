package com.minhld.dp;

public class DivisorGame extends Thread {
    public void run() {
        int n = 6;
        // 6: possible steps: 1, 2, 3
        // n 6 6
        // a 3 2
        // n 3 4
        // b 1 1
        // n 2 3
        // a 1 1
        // T n 2
        //   b 1
        //   F
        // 8: possible steps: 1, 2, 4

    }

    public boolean divisorGame(int n) {
        if (n == 1) return false;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            int j = i - 1;
            while (i - j > 0 && j > 0) {
                if (i % j == 0 && dp[i - j] == 0) {
                    dp[i] = 1;
                }
                j--;
            }
        }
        return dp[n] == 1;
    }

    public static void main(String args[]) {
        new DivisorGame().start();
    }
}
