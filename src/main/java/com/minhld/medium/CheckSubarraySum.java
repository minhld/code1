package com.minhld.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class CheckSubarraySum extends Thread {
    public void run() {
        int[] sample = {};
        int k = 2147483640; //2147483647
        System.out.println("val = " + checkSubarraySum(sample, k));
    }

    public static void main(String args[]) {
        new CheckSubarraySum().start();
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int total, sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
            sum += nums[i];
        }
        sum += nums[nums.length - 1];
        if (sum > 0 && sum < k) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            total = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                total += nums[j];
                if (total % k == 0) return true;
            }
        }
        return false;
    }

    /**
     * bruteforce solution
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            total = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                total += nums[j];
                if (total % k == 0) return true;
            }
        }
        return false;
    }
}
