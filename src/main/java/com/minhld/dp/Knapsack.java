package com.minhld.dp;/*
Solution: build the below matrix
each element is min possible number of elements
- 1 means not available,
- 0 means need 0 elements,
- n > 0: min number of elements

=> dp[i] the min of all min numbers in a row
0   0   0   0   0   -> 0 (dp[0])
0   0   0   0   0   -> -1 (dp[1])
1   0   0   0   0   -> 1 (dp[2])
0   1   0   0   0   -> 1
2   0   0   0   0   -> 2
2   2   1   0   0   -> 1
3   2   0   1   0   -> 1
2   3   2   0   0   -> 2
*/

public class Knapsack extends Thread {
    public void run() {
        // int[] w = new int[] { 2, 3, 5, 6, 8 };
        int[] w = new int[] { 1, 3, 5 };
        System.out.println("min value = " + knapsack(w, 11));
    }

    private int knapsack(int[] w, int s) {
        int[] dp = new int[s + 1];
        for (int i = 1; i <= s; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= s; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < w.length; j++) {
                int t = i - w[j];
                if (t >= 0 && dp[t] >= 0) {
                    min = Math.min(min, dp[t] + 1);
                }
            }
            dp[i] = min < Integer.MAX_VALUE ? min : -1;
        }
        return dp[s];
    }

    public static void main(String args[]) {
        new Knapsack().start();
    }
}
