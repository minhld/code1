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
        backtrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int n, int k, int start, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combinations().start();
    }
}
