package com.minhld.dp;

import java.util.Arrays;

public class ContainerWithMostWater extends Thread {
    public void run() {
        int[] h = { 6,8,6,2,5,4,8,6,6 };
        System.out.println("H = " + maxArea(h));
    }


    /**
     * bruteforce solution
     *
     * @param h height
     * @return max water capacity
     */
    public int maxArea(int[] h) {
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
