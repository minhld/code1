package com.minhld.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber2 {
    public boolean isHappy(int n) {
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
