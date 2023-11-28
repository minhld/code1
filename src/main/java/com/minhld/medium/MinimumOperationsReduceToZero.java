package com.minhld.medium;

public class MinimumOperationsReduceToZero {
    public int minOperations(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        int[] exNums = new int[nums.length + 2];
        for (int i = 1; i <= nums.length; i++) {
            exNums[i] = nums[i - 1];
        }
        int total = 0, step = 0;
        for (int i = 0; i < exNums.length; i++) {
            total += exNums[i];
            step = i;
            for (int j = exNums.length - 1; j > i; j--) {
                total += exNums[j];
                if (total == x) {
                    step += exNums.length - j;
                    min = Math.min(min, step);
                }
            }
        }
        return min;
    }
}
