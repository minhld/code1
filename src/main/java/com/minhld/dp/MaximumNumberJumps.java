package com.minhld.dp;

import java.util.Arrays;

public class MaximumNumberJumps extends Thread {
    public void run() {
        int[] nums =  { 0,3,1,2 };
        int target = 1;
        System.out.println(maximumJumps(nums, target));

    }

    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length + 1];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            dp[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] > -1 ? dp[j] + 1 : dp[j]);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new MaximumNumberJumps().start();
    }
}
