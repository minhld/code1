package com.minhld.medium;

import java.util.*;

public class IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] intvs = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                map.put(arr[i], new ArrayList<>(List.of(i)));
            }
        }
        for (int i = 0; i < arr.length; i++) {
            intvs[i] = 0;
            if (map.containsKey(arr[i])) {
                List<Integer> list = map.get(arr[i]);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == i) continue;
                    intvs[i] += Math.abs(i - list.get(j));
                }
            }
        }
        return intvs;
    }
}
