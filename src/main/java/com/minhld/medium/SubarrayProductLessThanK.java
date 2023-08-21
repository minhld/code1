package com.minhld.medium;

public class SubarrayProductLessThanK extends Thread {
    public void run() {
        int[] input = new int[] { 10,9,10,4,3,8,3,3,6,2,10,10,9,3 };
        numSubarrayProductLessThanK(input, 19);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod = 1;
            System.out.print(i + ": ");
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                if (prod < k) {
                    System.out.print(prod + "," + nums[j] + " ");
                    count++;
                }
            }
            System.out.println();
        }
        return count;
    }

    public static void main(String args[]) {
        new SubarrayProductLessThanK().start();
    }
}
