package com.minhld.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations extends Thread {
    public void run() {
        int n = 4;
        int k = 3;
        System.out.println("res = " + combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list;
        for (int i = 1; i <= n + 1 - k; i++) {
            list = new ArrayList<>();
            list.add(i);
            backtrack(n, k, i, result, list);
        }
        return result;
    }

    public void backtrack(int n, int k, int i, List<List<Integer>> r, List<Integer> c) {
        if (c.size() == k) {
            r.add(c);
            return;
        }

        List<Integer> p;
        for (int j = i + 1; j <= n; j++) {
            p = new ArrayList<>(c);
            p.add(j);
            backtrack(n, k, j, r, p);
        }
    }

    public static void main(String[] args) {
        new Combinations().start();
    }
}
