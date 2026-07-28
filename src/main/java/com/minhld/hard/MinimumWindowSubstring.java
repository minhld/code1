package com.minhld.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring extends Thread {
    public void run() {
        String s = "ADOABECODEBNC";
        String t = "ABCA";
        System.out.print("Res: " + minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";

        int[] cnt = new int[Character.MAX_VALUE + 1];
        for (char c : t.toCharArray()) cnt[c]++;

        int left = 0, missing = t.length(), start = 0, min = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (cnt[s.charAt(right)]-- > 0) missing--;
            while (missing == 0) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                if (++cnt[s.charAt(left++)] > 0) missing++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    /*
    public String minWindow(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : t.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        char[] arr = s.toCharArray();
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            Map<Character, Integer> r = new HashMap<>(m);
            int j = i;
            while (j < arr.length && !r.isEmpty()) {
                r.computeIfPresent(arr[j++], (k, v) -> v > 1 ? v - 1 : null);
            }
            if (!r.isEmpty()) return res;
            else if (min > j - i) {
                min = j - i;
                res = s.substring(i, j);
            }
        }
        return res;
    }
    */

    public static void main(String[] args) {
        new MinimumWindowSubstring().start();
    }
}
