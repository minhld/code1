package com.minhld.dp;

import java.util.Arrays;

public class ContainerWithMostWater extends Thread {
    public void run() {
        int[] h = { 6,8,6,2,5,4,8,6,6 };
        System.out.println("H = " + maxArea(h));
    }

    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(h[l], h[r]) * (r - l));
            if (h[l] < h[r]) l++;
            else r--;
        }
        return max;
    }

    /**
     * bruteforce solution
     *
     * @param h height
     * @return max water capacity
     */
    public int maxArea2(int[] h) {
        int len = h.length;
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.min(h[i], h[j]) * (i - j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new ContainerWithMostWater().start();
    }
}
