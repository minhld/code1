package com.minhld.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();

        dp[0] = nums[0];
        deque.add(0);
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k) deque.pollFirst();

            int bestIndex = deque.getFirst();
            dp[i] = dp[bestIndex] + nums[i];

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new JumpGame6().start();
    }
}
