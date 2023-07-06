package com.minhld.medium;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {
    public static void main(String args[]) {
        String[] arr = new String[0];
        if (!ArrayUtils.isEmpty(arr)) {
            boolean isAvail = Arrays.stream(arr).anyMatch("abc"::equals);
            System.out.println("avail = " + isAvail);
        }
    }

    // time limit exceeded
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        List<Integer> pList = new ArrayList<>();
        pList.add(2);
        int i = 3, count = 0;
        while (i < n) {
            count = 0;
            for (int j : pList) {
                count++;
                if (i % j == 0) break;
            }
            if (count == pList.size()) pList.add(i);
            i++;
        }
        return pList.size();
    }
}
