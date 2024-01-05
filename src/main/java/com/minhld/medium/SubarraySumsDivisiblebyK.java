package com.minhld.medium;

public class SubarraySumsDivisiblebyK {



    /**
     * bruce-force solution
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
