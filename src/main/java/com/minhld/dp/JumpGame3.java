package com.minhld.dp;

import java.util.HashSet;
import java.util.Set;

public class JumpGame3 extends Thread {
    public void run() {
        int[] input = { 58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,68,71,20,22,48,74,2,65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35 };
        System.out.println("result = " + canReach(input, 46));
    }

    public static void main(String[] args) {
        new JumpGame3().start();
    }

    public boolean canReach(int[] a, int s) {
        Set<Integer> t = new HashSet<>();
        return canReach(a, s, t);
    }

    private boolean canReach(int[] a, int s, Set<Integer> t) {
        if (s < 0 || s >= a.length || t.contains(s)) return false;
        if (a[s] == 0) return true;
        t.add(s);
        boolean l = canReach(a, s - a[s], t);
        boolean r = canReach(a, s + a[s], t);
        return l || r;
    }
}
