package com.minhld.medium;

import java.util.*;

public class IntervalsBetweenIdenticalElements {
    public long[] getDistances2(int[] arr) {
        return null;
    }
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] intvs = new long[arr.length];
        List<Integer> list;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list = map.get(arr[i]);
                for (int j = 0; j < list.size(); j++) {
                    intvs[list.get(j)] += Math.abs(list.get(j) - i);
                    intvs[i] += Math.abs(list.get(j) - i);
                }
                list.add(i);
            } else {
                map.put(arr[i], new ArrayList<Integer>(List.of(i)));
            }
        }
        return intvs;
    }
}
