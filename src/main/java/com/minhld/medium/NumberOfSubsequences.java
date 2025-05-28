package com.minhld.medium;

public class NumberOfSubsequences extends Thread {
    public void run() {
        int[] nums = new int[] { 2,3,3,4,6,7 };
        int target = 12;
        System.out.println("result = " + numSubseq(nums, target));
    }

    public int numSubseq(int[] nums, int target) {
        int f = 0, l = nums.length - 1;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[i] + nums[j] <= target) {
                    total += i + 1 < j ? ((j - i) * (j - i - 1) / 2) + 1 : 1;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        new NumberOfSubsequences().start();
    }
}
