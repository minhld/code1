package com.minhld.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum extends Thread {
    public void run() {
        int[] arr = new int[]{ 3,2,4 };
        int[] res = twoSum(arr, 6);
        Map<Character, Integer> m = new LinkedHashMap<>();

        System.out.println(" result = " + res);
    }

    public static void main(String[] args) {
        new TwoSum().start();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//        }
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (m.containsKey(r)) {
                return new int[] { i, m.get(r) };
            }
            m.put(nums[i], i);
        }
        return new int[2];
    }
//
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (indexMap.containsKey(target - nums[i])) {
//                return new int[] { indexMap.get(target - nums[i]), i };
//            }
//            indexMap.put(nums[i], i);
//        }
//        return new int[2];
//    }
}
