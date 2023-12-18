package com.minhld.trie;

import java.util.List;

public class TestTrie extends Thread {
    public void run() {
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel","help","helps","helping");
        Trie trie = new Trie(words);
        System.out.println(trie.suggest("hel"));
    }

    public static void main(String[] args) {
        new TestTrie().start();
    }
}
