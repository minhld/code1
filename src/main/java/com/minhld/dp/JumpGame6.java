package com.minhld.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class JumpGame6 extends Thread {
    public void run() {
        int[] nums = loadInput();
        int k = 90000;
        System.out.println("res = " + maxResult(nums, k));
    }

    private int[] loadInput() {
        try {
            String input = Files.readString(Path.of("src/main/resources/jump_game6_large_input.txt")).trim();
            return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read JumpGame6 input", e);
        }
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1] = Integer.MIN_VALUE;
            for (int j = Math.max(i - k, 0); j < i; j++) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + nums[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new JumpGame6().start();
    }
}
