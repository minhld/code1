package com.minhld.medium;

public class FindIndex2 {
    public int hIndex(int[] c) {
        int max = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            int min = Math.min(c[i], c.length - i);
            max = Math.max(max, min);
        }
        return max;
    }
}
