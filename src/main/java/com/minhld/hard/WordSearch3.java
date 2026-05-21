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
        String[] words = { "ABCE", "ABCESEEEFS" };

        System.out.println("result = " + findWords(board, words));
    }

    public static void main(String[] args) {
        new WordSearch3().start();
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, trie, set);
            }
        }
        return set.stream().toList();
    }

    private void findWords(char[][] board, int i, int j, Trie trie, Set<String> result) {
        Map<Character, TrieNode> children = trie.root.children;
        for (char c : children.keySet()) {
            if (c == board[i][j]) {
                dfs(board, i, j, children.get(c), result, new int[board.length][board[0].length]);
                break;
            }
        }
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, Set<String> result, int[][] mark) {
        mark[i][j] = 1;
        if (root.word != null) {
            result.add(root.word);
            if (root.children == null) return;
        }
        if (i > 0 && mark[i - 1][j] == 0 && root.children.containsKey(board[i - 1][j])) dfs(board, i - 1, j, root.children.get(board[i - 1][j]), result, mark);
        if (j > 0 && mark[i][j - 1] == 0 && root.children.containsKey(board[i][j - 1])) dfs(board, i, j - 1, root.children.get(board[i][j - 1]), result, mark);
        if (i < board.length - 1 && mark[i + 1][j] == 0 && root.children.containsKey(board[i + 1][j])) dfs(board, i + 1, j, root.children.get(board[i + 1][j]), result, mark);
        if (j < board[0].length - 1 && mark[i][j + 1] == 0 && root.children.containsKey(board[i][j + 1])) dfs(board, i, j + 1, root.children.get(board[i][j + 1]), result, mark);
        mark[i][j] = 0;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            root.insert(word, 0);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        Character c;
        String word;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public TrieNode(char c) {
            this.children = new HashMap<>();
            this.c = c;
        }

        public void insert(String word, int idx) {
            if (idx == word.length()) return;
            char fc = word.charAt(idx);
            TrieNode cc = this.children.computeIfAbsent(fc, TrieNode::new);
            if (idx < word.length() - 1) cc.insert(word, idx + 1);
            else cc.word = word;
        }
    }
}
