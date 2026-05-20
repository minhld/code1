package com.minhld.hard;

import java.util.*;

/**
 * using Trie
 */
public class WordSearch3 extends Thread {
    public void run() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String[] words = { "ABD", "ABCESEEEFS" };

        System.out.println("result = " + findWords(board, words));
    }

    public static void main(String[] args) {
        new WordSearch3().start();
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        if (root.word != null) {
            result.add(root.word);
            return;
        }
        if (i > 0 && root.children.containsKey(board[i - 1][j])) dfs(board, i - 1, j, root.children.get(board[i - 1][j]), result);
        if (j > 0 && root.children.containsKey(board[i][j - 1])) dfs(board, i, j - 1, root.children.get(board[i][j - 1]), result);
        if (i < board.length - 1 && root.children.containsKey(board[i + 1][j])) dfs(board, i + 1, j, root.children.get(board[i + 1][j]), result);
        if (j < board[0].length - 1 && root.children.containsKey(board[i][j + 1])) dfs(board, i, j + 1, root.children.get(board[i][j + 1]), result);
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            root.insert(word);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        char c;
        String word;

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
            else cc.word = word;
        }
    }
}
