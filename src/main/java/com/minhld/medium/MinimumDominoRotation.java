package com.minhld.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDominoRotation extends Thread {
    public void run() {
        int[] tops =    new int[] { 1,2,1,1,1,2,2,2 };
        int[] bottoms = new int[] { 2,1,2,2,2,2,2,2 };
        System.out.println("result = " + minDominoRotations(tops, bottoms));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int up = tops[0], down = bottoms[0];
        int upScore = findCompleteItem(up, tops, bottoms);
        int downScore = findCompleteItem(down, tops, bottoms);
        int min = Math.min(upScore, downScore);
        return min < Integer.MAX_VALUE ? min : -1;
    }

    private int findCompleteItem(int n, int[] tops, int[] bottoms) {
        int len = tops.length, up = 0, down = 0;
        for (int i = 0; i < len; i++) {
            if (tops[i] != n && bottoms[i] != n) return Integer.MAX_VALUE;
            else if (tops[i] == n && bottoms[i] == n) continue;
            if (tops[i] == n) up++;
            if (bottoms[i] == n) down++;
        }
        return Math.min(up, down);
    }

    public static void main(String[] args) {
        new MinimumDominoRotation().start();
    }
}
