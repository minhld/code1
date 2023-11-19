package com.minhld.medium;

import java.util.*;

public class LongestSubstringContainingVowelsEvenCounts {

    public int findTheLongestSubstring(String s) {
        int res = 0, cur = 0, n = s.length();
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; i++) {
            if ("aeiou".indexOf(s.charAt(i)) >= 0) {
                cur ^= 1 << "aeiou".indexOf(s.charAt(i)) + 1;
            }
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }


    /**
     * brute force solution
     * @param s
     * @return
     */
    public int findTheLongestSubstring2(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer>[] maps = new HashMap[s.length() + 1];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
            for (char c : set) {
                maps[i].put(c, 0);
            }
        }
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            maps[i + 1].putAll(maps[i]);
            if (set.contains(c)) {
                maps[i + 1].put(c, maps[i + 1].get(c) + 1);
            }
        }
        boolean isOddHappened = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                isOddHappened = false;
                for (char k : set) {
                    if ((maps[j].get(k) - maps[i].get(k)) % 2 == 1) {
                        isOddHappened = true;
                        break;
                    }
                }
                if (!isOddHappened) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
