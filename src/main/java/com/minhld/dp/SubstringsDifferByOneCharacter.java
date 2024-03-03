package com.minhld.dp;

public class SubstringsDifferByOneCharacter {
    public int countSubstrings(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] == 0 ? 0 : dp[i][j];
                } else {
                    int k = i - 1, l = j - 1;
                    dp[i + 1][j + 1] = 1;
                    while (k >= 0 && l >= 0 && s.charAt(k) == t.charAt(l)) {
                        dp[i + 1][j + 1]++;
                        k--; l--;
                    }
                }
                total += dp[i + 1][j + 1];
            }
        }
        return total;
    }
}
