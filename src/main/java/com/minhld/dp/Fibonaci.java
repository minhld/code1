package com.minhld.dp;

public class Fibonaci extends Thread {
    public void run() {
        int n = 40;
        long startTime = System.nanoTime();
        System.out.println("max (recursive) = " + fib_rec(n));
        System.out.println("take " + (System.nanoTime() - startTime) + "ns");
        startTime = System.nanoTime();
        System.out.println("max (dp) = " + fib(n));
        System.out.println("take " + (System.nanoTime() - startTime) + "ns");
    }

    private long fib_rec(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib_rec(n - 1) + fib_rec(n - 2);
    }

    private long fib(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String args[]) {
        new Fibonaci().start();
    }
}
