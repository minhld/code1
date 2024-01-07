package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK extends Thread {

    public void run() {
        System.out.println("remain = " + (9 % 2));
    }

    public static void main(String[] args) {
        new SubarraySumsDivisiblebyK().start();
    }

    /**
     * O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, r = 0, t = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + (nums[i] > 0 ? nums[i] : nums[i] % k + k);
            r = sums[i + 1] % k;
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        for (int key : map.keySet()) {
            t = map.get(key);
            if (t > 1) {
                count += t * (t - 1) / 2;
            }
        }
        return count;
    }

    /**
     * bruce-force solution O(n^2)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK1(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {
                if ((sums[j] - sums[i]) % k == 0) count++;
            }
        }
        return count;
    }
}
