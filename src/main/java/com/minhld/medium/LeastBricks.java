package com.minhld.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.isEmpty() || wall.get(0).isEmpty()) return 0;
        int rowSum = wall.get(0).stream().reduce(0, Integer::sum);
        int accVal;
        Map<Integer, Integer> cross = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            accVal = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                accVal += wall.get(i).get(j);
                if (accVal < rowSum) {
                    cross.put(accVal - 1, cross.getOrDefault(accVal - 1, 0) + 1);
                }
            }
        }
        int max = cross.values().stream()
                .mapToInt(v -> v)
                .max()
                .orElse(0);
        return wall.size() - max;
    }
}
