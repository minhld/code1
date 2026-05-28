package com.minhld.medium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JumpGame7 extends Thread {
    public void run() {
        String input = loadInput();
        System.out.println("result = " + canReach(input, 1, 49999));
//        String input = "011000001011110000";
//        System.out.println("result = " + canReach(input, 4, 7));
//        String input = "0000000000";
//        System.out.println("result = " + canReach(input, 2, 5));
//        String input = "011100110101011011011110";
//        System.out.println("result = " + canReach(input, 4, 5));
//        String input = "011010";
//        System.out.println("result = " + canReach(input, 2, 3));
    }

    public static void main(String[] args) {
        new JumpGame7().start();
    }

    private String loadInput() {
        try {
            return Files.readString(Path.of("src/main/resources/jump_game7_large_input.txt")).trim();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read JumpGame7 input", e);
        }
    }

    /*
    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if (s.charAt(len - 1) == '1') return false;

        int[] dp = new int[len + 1];
        dp[0] = 1;
        int lb = 0, rb = 0;
        while (rb <= len - 1) {
            int l = 0, r = 0;
            for (int i = 0; i <= rb - lb; i++) {
                if (dp[lb + i] == 0) continue;
                for (int j = minJump; j <= maxJump; j++) {
                    if (lb + i + j == len - 1) {
                        return true;
                    } else if (lb + i + j < len -1 && s.charAt(lb + i + j) == '0') {
                        dp[lb + i + j] = 1;
                        l = l == 0 ? lb + i + j : l;
                        r = lb + i + j;
                    }
                }
            }
            if (l == 0 || r == 0) return false;
            if (l == len - 1 || r == len - 1) return true;
            if (l + minJump < r) l = r - minJump;
            lb = l;
            rb = r;
        }
        return false;
    }
    */

    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if (s.charAt(len - 1) == '1') return false;

        boolean[] dp = new boolean[len];
        dp[0] = true;
        int reachable = 0;

        for (int i = 1; i < len; i++) {
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }
            dp[i] = reachable > 0 && s.charAt(i) == '0';
        }

        return dp[len - 1];
    }
}
