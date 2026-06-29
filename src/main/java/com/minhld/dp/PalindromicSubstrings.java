package com.minhld.dp;

public class PalindromicSubstrings extends Thread {
    public void run() {
        String s = "aa";
        System.out.println("res = " + countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += count(s, i, i);
            count += count(s, i, i + 1);
        }
        return count;
    }

    private int count(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) {
            count++;
        }
        return count;
    }

//    public int countSubstrings(String s) {
//        int n = s.length();
//        int[][] dp = new int[n + 1][n + 1];
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            count++;
//            int j = i + 1;
//            while (j < n && s.charAt(j) == c) {
//                count++;
//                dp[i][j] = 1;
//                j++;
//            }
//            int l = i - 1, r = j;
//            while (l >= 0 && r < n) {
//                if (s.charAt(l) == s.charAt(r) && dp[l][r] == 0) {
//                    count++;
//                    dp[l][r] = 1;
//                    l--;
//                    r++;
//                } else break;
//            }
//            j = 1;
//            while (i - j >= 0 && i + j < n) {
//                if (s.charAt(i - j) == s.charAt(i + j) && dp[i - j][i + j] == 0) {
//                    count++;
//                    dp[i - j][i + j] = 1;
//                    j++;
//                } else break;
//            }
//        }
//
//        return count;
//    }

//    public int countSubstrings(String s) {
//        int n = s.length();
//        int[][] dp = new int[n + 1][n + 1];
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = n - 1; j >= 0; j--) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i + 1][n - j] = dp[i][n - j - 1] + 1;
//                    if (dp[i + 1][n - j] > 0 && (i + 1 == j + dp[i + 1][n - j] || i == j)) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        new PalindromicSubstrings().start();
    }
}
