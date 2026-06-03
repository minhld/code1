package com.minhld.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumRepeatingSubstring extends Thread {
    public void run() {

    }

    public int maxRepeating(String s, String w) {
        int n = s.length(), m = w.length();
        int[][] dp = new int[n + 1][m + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = s.charAt(i) == w.charAt(j) ? dp[i][j] + 1 : 0;
                if (dp[i + 1][j + 1] == m) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new MaximumRepeatingSubstring().start();
    }
}
