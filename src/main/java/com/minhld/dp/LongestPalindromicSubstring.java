package com.minhld.dp;

public class LongestPalindromicSubstring extends Thread {
    public void run() {
        String s = "aacabdkacaa";
        System.out.println("res = " + longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int max = 0, off = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i + 1][n - j] = dp[i][n - j - 1] + 1;
                    if (max < dp[i + 1][n - j] && i + 1 == j + dp[i + 1][n - j]) {
                        max = dp[i + 1][n - j];
                        off = i + 1;
                    }
                }
            }
        }
        return s.substring(off - max, off);
    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().start();
    }
}
