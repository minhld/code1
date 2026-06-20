package com.minhld.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 extends Thread {
    public void run() {
//        List<String> words = List.of("cats","dog","sand","and","cat");
//        String s = "catsanddog";
        List<String> words = List.of("apple","pen","applepen","pine","pineapple");
        String s = "pineapplepenapple";

        List<String> list = wordBreak(s, words);
        System.out.println("Result: " + list);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        wordBreak(s, 0, set, new Boolean[s.length()], list, new StringBuilder());
        return list;
    }

    public boolean wordBreak(String s, int i, Set<String> set, Boolean[] memo, List<String> list, StringBuilder out) {
        if (memo[i] != null) return memo[i];
        String l = s.substring(i);
        if (set.contains(l)) {
//            out.append(l);
            list.add(out + l);
            return true;
        }
        StringBuilder w = new StringBuilder();
        boolean wf = false;
        for (int j = i; j < s.length(); j++) {
            w.append(s.charAt(j));
            if (set.contains(w.toString())) {
                out.append(w).append(" ");
                wf = wordBreak(s, j + 1, set, memo, list, out);
                if (wf) out = new StringBuilder();
            }
        }
        return memo[i] = wf;
    }

    public static void main(String[] args) {
        new WordBreak2().start();
    }
}
