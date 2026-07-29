package com.minhld.hard;

import java.util.*;

public class SlidingWindowMaximum extends Thread {
    public void run() {
//        int[] nums = { 1,3,-1,-3,5,3,6,7 };
        int[] nums = { 1,3,-1,-3,-5,3,6,7 };
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println("res = " + Arrays.toString(res));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.getFirst() <= i - k) q.removeFirst();
            addDeQueue(nums, q, i);
            if (i >= k - 1) res[i - k + 1] = nums[q.getFirst()];
        }
        return res;
    }

    private void addDeQueue(int[] nums, Deque<Integer> q, int i) {
        while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.removeLast();
        q.addLast(i);
    }

    public static void main(String[] args) {
        new SlidingWindowMaximum().start();
    }
}
