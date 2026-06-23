package com.minhld.dp;

public class PalindromicSubstrings extends Thread {
    public void run() {
        String s = "aaa";
        System.out.println("res = " + countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i + 1][n - j] = dp[i][n - j - 1] + 1;
                    if (dp[i + 1][n - j] > 0 && i + 1 == j + dp[i + 1][n - j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new PalindromicSubstrings().start();
    }
}
