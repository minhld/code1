package com.minhld.dp;

public class LCS extends Thread {
    public void run() {
        String s1 = "quetzalcoatl";
        String s2 = "tezcatlipoca";


    }

    private int findLCS(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return 0;
    }

    public static void main(String args[]) {
        new LCS().start();
    }
}
