package com.minhld.medium;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumJumpsReachHome extends Thread {
    public void run() {
//        int[] forbidden = { 8,3,16,6,12,20 };
//        int a = 15, b = 13, x = 11;
//        int[] forbidden = { 14,4,18,1,15 };
//        int a = 3, b = 15, x = 9;
//        int[] forbidden = { 162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98 };
//        int a = 29, b = 98, x = 80;
        int[] forbidden = { 1998 };
        int a = 1999, b = 2000, x = 2000;

        System.out.println("res = " + minimumJumps(forbidden, a, b, x));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> fb = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        int limit = Math.max(x, Collections.max(fb)) + a + b;
        Map<Integer, Boolean> steps = new HashMap<>();  // key: step index, value: can move backward
        steps.put(0, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int depth = 0, len = q.size();
        while (!q.isEmpty()) {
            int i = q.poll();
            len--;
            if (i == x) return depth;   // if it gets home (x)
            if (!fb.contains(i + a) && (i + a <= limit) && (!steps.containsKey(i + a) || !steps.get(i + a))) {
                q.add(i + a);
                steps.put(i + a, true);
            }
            if (i - b >= 0 && !fb.contains(i - b) && steps.get(i) && !steps.containsKey(i - b)) {
                q.add(i - b);
                steps.put(i - b, false);
            }
            if (len == 0 && !q.isEmpty()) {
                len = q.size();
                depth++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new MinimumJumpsReachHome().start();
    }
}
