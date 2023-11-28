package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsReduceToZero {
    public int minOperations(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> lMap = new HashMap<>();
        int total = 0, currTotal = 0, lStep = 0, cStep = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (x - total == 0) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            lMap.putIfAbsent(currTotal, lStep++);
            currTotal += nums[i];
            if (lMap.containsKey(x - (total - currTotal))) {
                cStep = lMap.get(x - (total - currTotal)) - 1;
                min = Math.min(min, nums.length - i + cStep);
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

    /**
     * bruce-force solution
     *
     * @param nums
     * @param x
     * @return
     */
    public int minOperations2(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        int[] exNums = new int[nums.length + 2];
        for (int i = 1; i <= nums.length; i++) {
            exNums[i] = nums[i - 1];
        }
        int lTotal = 0, rTotal = 0, step = 0;
        for (int i = 0; i < exNums.length; i++) {
            lTotal += exNums[i];
            rTotal = 0;
            step = i;
            for (int j = exNums.length - 1; j > i; j--) {
                rTotal += exNums[j];
                step++;
                if (lTotal + rTotal == x) {
                    min = Math.min(min, step - 1);
                }
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }
}
