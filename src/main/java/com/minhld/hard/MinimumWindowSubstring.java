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

    public static void main(String[] args) {
        new MinimumWindowSubstring().start();
    }
}
