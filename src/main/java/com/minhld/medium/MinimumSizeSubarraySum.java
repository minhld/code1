package com.minhld.medium;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length, c = 0, min = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            while (sum[i + 1] - sum[c] >= k) {
                min = Math.min(min, i + 1 - c++);
            }
        }
        return min < Integer.MAX_VALUE ? min : 0;
    }
}
