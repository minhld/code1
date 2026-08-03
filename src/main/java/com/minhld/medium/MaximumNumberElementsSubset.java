package com.minhld.medium;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class MaximumNumberElementsSubset extends Thread {
    public void run() {
//        int[] nums = { 4,36,9,16,1,1,4,121,64,4 };
//        int[] nums = { 14,14,196,196,38416,38416 };
//        int[] nums = { 1,1,1,1,1,1,1,1,1,1,2,4,8,16,32,64,128,256,512,1024 };
//        int[] nums = { 65025,312481,107584,148996,322624,194481,570025,15376,123904,848241,88804,47961,117649,66564,295936,271441,16900,474721,27556,285156,11236,175561,917764,968256,16,38025,312481,426409,354025,8464,522729,60516,210681,378225,638401,101124,697225,427716,262144,940900,988036,324900,151321,309136,178929,168921,189225,4,301401,659344,786769,964324,15625,302500,56644,61504,31684,369664,345744,19321,59049,5041,40000,147456,372100,708964,171396,214369,707281,484,49729,82944,100489,103684,58564,208849,946729,84100,4,600625,334084,683929,9604,245025,97969,147456,160801,434281,223729,294849,166464,432964,518400,376996,17424,315844,256,737881,10000,632025 };
        int[] nums = { 131073,65537,65537 };
        System.out.println("res = " + maximumLength(nums));
    }

    public int maximumLength(int[] nums) {
        Map<Long, Long> map = new TreeMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0L) + 1L);
        }
        long max = 1, total = 1;
        for (long k : map.keySet()) {
            long v = k;
            if (v == 1) {
                long val = map.get(v);
                total = val % 2 == 0 ? val - 1L : val;
                max = Math.max(max, total);
            } else {
                while (map.containsKey(v * v) && map.get(v) >= 2) {
                    v = v * v;
                    total += 2;
                    max = Math.max(max, total);
                }
            }
            total = 1;
        }
        return (int) max;
    }

    /**
     * Clearer equivalent of {@link #maximumLength(int[])}.
     *
     * A valid subset has the form x, x^2, x^4, ... , x^4, x^2, x:
     * every value before the middle needs two occurrences and the middle needs one.
     */
    public int maximumLengthSimplified(int[] nums) {
        Map<Long, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.merge((long) num, 1, Integer::sum);
        }

        int longest = 0;

        // 1 stays 1 after squaring, so it can only contribute an odd count.
        int ones = frequency.getOrDefault(1L, 0);
        longest = ones % 2 == 0 ? ones - 1 : ones;

        for (long start : frequency.keySet()) {
            if (start == 1) {
                continue;
            }

            int length = 1; // The current value can be the single middle element.
            long current = start;
            while (frequency.get(current) >= 2) {
                long next = current * current;
                if (!frequency.containsKey(next)) {
                    break;
                }
                length += 2;
                current = next;
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }

    public static void main(String[] args) {
        new MaximumNumberElementsSubset().start();
    }
}
