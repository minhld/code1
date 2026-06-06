package com.minhld.hard;

import java.util.Arrays;

public class BestTimeBuySellStockIV extends Thread{
    public void run() {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println("res = " + maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {

    }

    public static void main(String[] args) {
        new BestTimeBuySellStockIV().start();
    }
}
