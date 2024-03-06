package com.minhld.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int total = 0;
        boolean hasOdd = false;
        for (int val : map.values()) {
            if (val % 2 == 0) total += val;
            if (val % 2 == 1) {
                if (val > 2) total += val - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) total += 1;
        return total;
    }
}
