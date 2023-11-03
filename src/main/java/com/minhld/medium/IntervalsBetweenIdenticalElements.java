package com.minhld.medium;

import java.util.*;
import java.util.stream.Stream;

public class IntervalsBetweenIdenticalElements extends Thread {
    public void run() {
        int[] samples = {1, 2, 3, 1, 3, 2, 2, 3, 5, 7, 3, 7, 3 };
        long[] res = getDistances2(samples);
        // [3,9,25,3,19,5,6,16,0,2,19,2,25]
        Stream.<long[]>of(res).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new IntervalsBetweenIdenticalElements().start();
    }

    public long[] getDistances2(int[] arr) {
        Map<Integer, List<Long>> map = new HashMap<>();
        Map<Integer, List<Long>> totalMap = new HashMap<>();
        List<Long> list, totalList;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add((long) i);
                totalList = totalMap.get(arr[i]);
                totalList.add(totalList.get(totalList.size() - 1) + i);
            } else {
                map.put(arr[i], new ArrayList<>(List.of((long) i)));
                totalMap.put(arr[i], new ArrayList<>(List.of((long) i)));
            }
        }
        long[] intvs = new long[arr.length];
        for (int key : map.keySet()) {
            list = map.get(key);
            totalList = totalMap.get(key);
            for (int i = 0; i < list.size(); i++) {
                intvs[list.get(i).intValue()] = ((long) list.get(i) * (i + 1) - totalList.get(i))
                        + (totalList.get(list.size() - 1) - totalList.get(i) - list.get(i) * (list.size() - i - 1));
            }
        }
        return intvs;
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
