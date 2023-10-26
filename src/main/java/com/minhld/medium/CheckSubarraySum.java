package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum extends Thread {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum % k)) map.put(sum % k, i + 1);
            else if (i > map.get(sum % k)) return true;
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
