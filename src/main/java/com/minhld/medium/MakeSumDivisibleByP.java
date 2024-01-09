package com.minhld.medium;

import java.util.*;

public class MakeSumDivisibleByP extends Thread {
    public void run() {
//        int[] data = new int[] { 8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2 };
        int[] data = new int[] { 17,6,22,31,25,4,18,32,18,26,2,31,26,8,12,2 };
        int p = 142;

//        System.out.println("sum = "  + (int) Arrays.stream(data).mapToLong(i -> i).sum());
        System.out.println("sum = " + minSubarray(data, p));
    }

    public int minSubarray(int[] nums, int p) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(0);
        int[] sum = new int[nums.length + 1];
        int min = Integer.MAX_VALUE, l = 0;
        int total = (int) Arrays.stream(nums).mapToLong(i -> i).sum();
        List<Integer> list;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            l = sum[i + 1] % p;
            if (map.containsKey(l)) {
                map.get(l).add(i + 1);
            } else {
                list = new ArrayList<>();
                list.add(i + 1);
                map.put(l, list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            l = (p - ((total - sum[i + 1]) % p)) % p;
            if (map.containsKey(l)) {
                for (int v : map.get(l)) {
                    if (v <= i + 1 && i - v < nums.length - 1) {
                        min = Math.min(min, i - v + 1);
                    }
                }
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

    public static void main(String[] args) {
        new MakeSumDivisibleByP().start();
    }
}
