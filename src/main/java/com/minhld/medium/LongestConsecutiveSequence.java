package com.minhld.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence extends Thread {
    public void run() {
//        int[] nums = { 100,4,200,1,3,2 };
//        int[] nums = { 1,0,-1 };
//        int[] nums = { 4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3 };
        int[] nums = { -3,2,8,5,1,7,-8,2,-8,-4,-1,6,-6,9,6,0,-7,4,5,-4,8,2,0,-2,-6,9,-4,-1 };

        System.out.println("res = " + longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            values.add(num);
        }

        int longest = 0;

        for (int num : values) {
            if (!values.contains(num - 1)) { // sequence start
                int length = 1;
                while (values.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    /*
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int max = 1;
        for (int k : map.keySet()) {
            int i = 1;
            int iMax = 1;
            while (map.containsKey(k - i) && map.get(k - i) > 0) {
                map.put(k - i, 0);
                i++;
                iMax++;
            }
            i = 1;
            while (map.containsKey(k + i) && map.get(k + i) > 0) {
                map.put(k + i, 0);
                i++;
                iMax++;
            }
            max = Math.max(max, iMax);
        }
        return max;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int max2 = 1;
        for (int i = min; i < max; i++) {
            if (map.containsKey(i) && map.containsKey(i + 1)) {
                map.put(i + 1, map.get(i) + 1);
                max2 = Math.max(max2, map.get(i + 1));
            }
        }
        return max2;
    }

    public int longestConsecutive(int[] nums) {
        int[] a = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = 1;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = a[i - 1] + 1;
                max = Math.max(max, a[i]);
            }
        }
        return max;
    }
    */

    public static void main(String[] args) {
        new LongestConsecutiveSequence().start();
    }
}
