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

    boolean divisorGame(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
//            dp[i] =
        }
        return false;
    }

    public static void main(String args[]) {
        new DivisorGame().start();
    }
}
