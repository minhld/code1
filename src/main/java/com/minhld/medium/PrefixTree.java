package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Prefix Tree or Trie
 */
public class PrefixTree extends Thread {
    public void run() {
        Trie t =  new Trie();
        t.insert("apple");
        System.out.println("search " + t.search("apple"));
        t.insert("cat");
    }

    public static void main(String[] args) {
        new PrefixTree().start();
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            root.insert(word);
        }

        public boolean search(String word) {
            return find(word, true);
        }

        public boolean startsWith(String prefix) {
            return find(prefix, false);
        }

        private boolean find(String prefix, boolean exact) {
            TrieNode lastNode = root;
            for (char c : prefix.toCharArray()) {
                lastNode = lastNode.children.get(c);
                if (lastNode == null) return false;
            }
            return !exact || lastNode.isWord;
        }

        static class TrieNode {
            Map<Character, TrieNode> children;
            char c;
            boolean isWord;

            public TrieNode() {
                this.children = new HashMap<>();
            }

            public TrieNode(char c) {
                this.children = new HashMap<>();
                this.c = c;
            }

            public void insert(String word) {
                if (word == null || word.isEmpty()) return;
                char fc = word.charAt(0);
                TrieNode cc = this.children.computeIfAbsent(fc, TrieNode::new);
                if (word.length() > 1) cc.insert(word.substring(1));
                else cc.isWord = true;
            }
        }
    }
}
