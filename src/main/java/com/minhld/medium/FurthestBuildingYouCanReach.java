package com.minhld.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach extends Thread {
    public void run() {
//        int[] h = { 4,2,7,6,9,14,12 };
//        int b = 5, l = 1;
        int[] h = { 4,12,2,7,3,18,20,3,19 };
        int b = 10, l = 2;
        System.out.println("res= " + furthestBuilding(h, b, l));
    }

    /*
            20
        19       18
     7     3  2     12
   3   4
     */


    public int furthestBuilding(int[] h, int b, int l) {
        int[] dp = new int[h.length + 1];
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < h.length; i++) {
            q.add(h[i]);
        }

        for (int i = q.size(); i > 0; i--) {
            System.out.println("q val = " + q.poll());
        }

        return 0;
    }

    /*
    public int furthestBuilding(int[] h, int b, int l) {
        return maxSteps(h, 0, b, l);
    }

    private int maxSteps(int[] h, int i, int b, int l) {
        if (b < 0 || l < 0) return i - 1;
        if (i == h.length - 1) return i;

        if (h[i + 1] <= h[i]) return maxSteps(h, i + 1, b, l);
        if (b == 0 && l == 0) return i;
        else if (b == 0) return maxSteps(h, i + 1, b, l - 1);
        else if (l == 0) return maxSteps(h, i + 1, b - (h[i + 1] - h[i]), l);
        else return Math.max(
                    maxSteps(h, i + 1, b - (h[i + 1] - h[i]), l),
                    maxSteps(h, i + 1, b, l - 1));
    }
    */

    public static void main(String[] args) {
        new FurthestBuildingYouCanReach().start();
    }
}
