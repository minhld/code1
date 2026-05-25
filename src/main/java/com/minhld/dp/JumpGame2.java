package com.minhld.dp;

public class JumpGame2 extends Thread {
    public void run() {
//        int[] input = new int[] { 2,1,4,0,4,1,3,1,0,5 };
        int[] input = new int[] { 1,3,2 };
        System.out.println("result = " + jump(input));

    }

    public static void main(String[] args) {
        new JumpGame2().start();
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        dp[0][0] = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                dp[i][j] = 1;
            }
        }
        int[] min = new int[len + 1];
        min[0] = 0;
        min[1] = 1;
        for (int i = 1; i < len; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][i] == 1) {
                    min[i] = Math.min(min[i], min[j]) + 1;
                }
            }
        }
        return min[len - 1];
    }
}
