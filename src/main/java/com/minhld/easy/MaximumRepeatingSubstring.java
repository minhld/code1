package com.minhld.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumRepeatingSubstring extends Thread {
    public void run() {
        String s = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String w = "aaaba";
//        String s = "ababc";
//        String w = "ab";
        System.out.println("res = " + maxRepeating(s, w));
    }

    public int maxRepeating(String s, String w) {
        int n = s.length(), m = w.length();
        int[] dp = new int[n + 1];
        int i =0, count = 0, max = 0;
        while (i < n) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) == w.charAt(j)) {
                    dp[i + j + 1] = j == 0 ? 1 : dp[i + j] + 1;
                    if (j == m - 1 && dp[i + j + 1] == m && dp[i + j + 2 - m] == 1) {
                        count++;
                        max = Math.max(count, max);
                        i += j + 1;
                    }
                } else {
                    dp[i++ + j + 1] = 0;
                    count = 0;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new MaximumRepeatingSubstring().start();
    }
}
