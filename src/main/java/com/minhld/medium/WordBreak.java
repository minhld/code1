package com.minhld.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak extends Thread {
    public void run() {
        List<String> words = List.of("cats","dog","sand","and","cat");
        String s = "catsandog";
//        List<String> words = List.of("aaaa","aaa");
//        String s = "aaaaaaa";
//        List<String> words = List.of("go","goal","goals","special");
//        String s = "goalspecial";
//        List<String> words = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println("Res = " + wordBreak(s, words));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, 0, set, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s, int i, Set<String> set, Boolean[] memo) {
        if (memo[i] != null) return memo[i];
        if (set.contains(s.substring(i))) return true;

        StringBuilder w = new StringBuilder();
        boolean wf = false;
        for (int j = i; j < s.length(); j++) {
            w.append(s.charAt(j));
            if (set.contains(w.toString())) {
                wf = wordBreak(s, j + 1, set, memo);
                if (wf) break;
            }
        }
        return memo[i] = wf;
    }

    public static void main(String[] args) {
        new WordBreak().start();
    }
}
