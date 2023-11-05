package com.minhld.medium;

public class MinimumAdditionMakeBeautiful {
    public long makeIntegerBeautiful(long n, int target) {
        if (sum(n) <= target) return 0;
        String s = String.valueOf(n);
        long diff, totalDiff = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            diff = (long) Math.abs(10 - (s.charAt(i) - '0')) * (long) Math.pow(10, (s.length() - i - 1));
            totalDiff += diff;
            if (sum(n + diff) <= target) return totalDiff;
            s = String.valueOf(n + diff);
        }
        return totalDiff;
    }

    private long sum(long n) {
        String s = String.valueOf(n);
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += s.charAt(i) - '0';
        }
        return total;
    }
}
