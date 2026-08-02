package com.minhld.medium;

import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors extends Thread {
    public void run() {
        int bottom = 3;
        int top = 15;
        int[] special = {7,9,13};
        System.out.println("res = " + maxConsecutive(bottom, top, special));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length, max = 0;
        if (bottom < special[0]) max = Math.max(max, special[0] - bottom);
        for (int i = 1; i < n; i++) {
            if (special[i] - special[i - 1] > 1) max = Math.max(max, special[i] - special[i - 1] - 1);
        }
        if (top > special[n - 1]) max = Math.max(max, top - special[n - 1]);
        return max;
    }

    public static void main(String[] args) {
        new MaximumConsecutiveFloorsWithoutSpecialFloors().start();
    }
}
