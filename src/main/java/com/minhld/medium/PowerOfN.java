package com.minhld.medium;

public class PowerOfN extends Thread {
    public void run() {
        double x = 2;
        int n = -2;
        System.out.println("res = " + myPow(x, n));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double v = n > 0 ? x : 1 / x;
        double res = v;
        int c = dev(n);
        for (int i = 1; i <= c; i++) {
            res *= res;
        }
        int dist = (int) (n - dist(c, n));
        double w = dist > 0 ? x : 1 / x;
        for (int i = 1; i <= Math.abs(dist); i++) {
            res *= w;
        }
        return res;
    }

    private long dist(int p, int n) {
        long res = 1;
        for (int i = 1; i <= p; i++) {
            res *= 2;
        }
        return (n / Math.abs(n)) * res;
    }

    private int dev(int n) {
        double x = n;
        int c = 0;
        while (Math.abs(x) > 1) {
            x /= 2;
            c++;
        }
        return c;
    }

    /*
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }

        return result;
    }
    */

    public static void main(String[] args) {
        new PowerOfN().start();
    }
}
