package com.minhld.medium;

public class FindHIndex {
    public int hIndex(int[] c) {
        int len = c.length;
        int count = 0;
        int max = 0, min = 0;
        for (int i = len; i >= 0; i--) {
            count = 0;
            for (int j = 0; j < len; j++) {
                if (c[j] >= i) {
                    count++;
                }
            }
            if (count >= i) {
                min = Math.min(count, i);
                max = Math.max(min, max);
            }
        }
        return max;
    }
}
