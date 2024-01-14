package com.minhld.medium;

public class OperationsMakeArrayEqualZero extends Thread {
    public void run() {
        int[] arr = new int[] { 0,16,0,29,0,0,0,9,0,0,0,0,0,0,0,0,0,95,49,0,0,0,0,68 };
        System.out.println("res = " + checkArray2(arr, 24));
    }

    /**
     * O (n*k)
     * @param nums
     * @param k
     * @return
     */
    public boolean checkArray2(int[] nums, int k) {
        int val;
        for (int i = 0; i <= nums.length - k; i++) {
            val = nums[i];
            for (int j = i; j < i + k; j++) {
                nums[j] -= val;
                if (nums[j] < 0) return false;
            }
        }
        for (int i = nums.length - k; i < nums.length; i++) {
            if (nums[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new OperationsMakeArrayEqualZero().start();
    }
}
