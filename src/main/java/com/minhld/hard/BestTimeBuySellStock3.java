package com.minhld.hard;

import java.util.Arrays;

public class BestTimeBuySellStock3 extends Thread {
    public void run() {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("res = " + maxProfit(prices));
    }

    public int maxProfit(int[] p) {
        int k = 2;
        int[] profit = new int[k + 1];
        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);

        for (int price : p) {
            for (int l = 1; l <= k; l++) {
                buy[l] = Math.min(buy[l], price - profit[l - 1]);
                profit[l] = Math.max(profit[l], price - buy[l]);
            }
        }
        return profit[k];
    }

    public static void main(String[] args) {
        new BestTimeBuySellStock3().start();
    }
}
