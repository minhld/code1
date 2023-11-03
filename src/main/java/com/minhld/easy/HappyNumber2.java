package com.minhld.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber2 {
    // run a bit faster
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        String str = String.valueOf(n);
        int total = n, val;
        while (true) {
            str = String.valueOf(n);
            total = 0;
            for (int i = 0; i < str.length(); i++) {
                val = Integer.parseInt(String.valueOf(str.charAt(i)));
                total += val * val;
            }
            n = total;
            if (total == 1) return true;
            if (!set.contains(total)) {
                set.add(total);
            } else {
                return false;
            }
        }
    }

    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        int total = n;
        String str;
        while (true) {
            str = String.valueOf(total);
            total = str.chars()
                    .mapToObj(c -> (char) c - '0')
                    .mapToInt(i -> i * i)
                    .reduce(0, Integer::sum);
            if (total == 1) return true;
            if (set.contains(total)) return false;
            set.add(total);
        }
    }
}
