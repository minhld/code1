package com.minhld.dp;

public class JumpGame extends Thread {
    public void run() {

    }

    public static void main(String[] args) {
        new JumpGame().start();
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        boolean canJump;
        for (int i = 1; i < len; i++) {
            canJump = false;
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i) {
                    canJump = true;
                    break;
                }
            }
            if (!canJump) return false;
        }
        return true;
    }
}
