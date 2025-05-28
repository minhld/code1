package com.minhld.medium;

import com.minhld.utils.Utils;

public class MinimumElementsToAdd extends Thread {
    public void run() {
        int[] data = Utils.readData(this.getClass());
        int limit = 1000000;
        int goal = -1000000000;
        System.out.println("result = " + minElements(data, limit, goal));
    }

    public static void main(String[] args) {
        new MinimumElementsToAdd().start();
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long r = goal - sum;
        int cnt = (int) (Math.abs(r) / Math.abs(limit));
        return Math.abs(r) % Math.abs(limit) == 0 ? cnt : cnt + 1;
    }
}
