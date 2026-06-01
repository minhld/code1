package com.minhld.medium;

public class InterleavingString extends Thread {
    public static void main(String[] args) {
        new InterleavingString().start();
    }
    @Override
    public void run() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
//        String s1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
//        String s2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
//        String s3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
//        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println("res = " + isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;
                dp[i][j] = i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[m][n];
    }

//    public boolean isInterleave(String s1, String s2, String s3) {
//        return isInterleave(s1, 0, s2, 0, s3, 0);
//    }
//
//    int total = 0;
//    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
//        if (i3 == s3.length()) {
//            return i1 == s1.length() && i2 == s2.length();
//        }
//        boolean f = false, s = false;
//        if (i1 < s1.length() && i3 < s3.length() && s1.charAt(i1) == s3.charAt(i3)) {
//            f = isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
//            if (f) return true;
//        }
//        if (i2 < s2.length() && i3 < s3.length() && s2.charAt(i2) == s3.charAt(i3)) {
//            s = isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
//            return s;
//        }
//        return false;
//    }

}
