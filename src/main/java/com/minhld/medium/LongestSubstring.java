package com.minhld.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char c;
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (set.contains(c)) {
                while (c != s.charAt(left)) {
                    set.remove(s.charAt(left++));
                }
                set.remove(s.charAt(left++));
            }
            set.add(c);
            if (max < set.size()) max = set.size();
        }
        return max;
    }
}
