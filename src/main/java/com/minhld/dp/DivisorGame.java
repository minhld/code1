package com.minhld.dp;

public class DivisorGame extends Thread {
    public void run() {
        int n = 6;

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
