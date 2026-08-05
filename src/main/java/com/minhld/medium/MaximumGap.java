package com.minhld.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumGap extends Thread {
    public void run() {
        int[] nums = { 1000000000,99999999,9999999,999999,99999,9999,999,99,9 };
        System.out.println("res = " + maximumGap(nums));
    }

//    public int maximumGap(int[] nums) {
//        if (nums.length <= 1) return 0;
//        int prev = 0, next = Integer.MIN_VALUE, totalMax = 0;
//        return totalMax;
//    }

    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;

        Set<Integer> s = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int prev = 0, next = Integer.MIN_VALUE, totalMax = 0;
        for (int i = min; i <= max; i++) {
            if (s.contains(i)) {
                prev = next;
                next = i;
                if (prev > Integer.MIN_VALUE) {
                    totalMax = Math.max(totalMax, next - prev);
                }
            }
        }
        return totalMax;
    }

    public static void main(String[] args) {
        new MaximumGap().start();
    }
}
