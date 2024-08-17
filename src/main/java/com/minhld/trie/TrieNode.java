package com.minhld.trie;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNode {
    Map<Character, TrieNode> children;
    char c;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;
        char firstChar = word.charAt(0);
        TrieNode child = children.computeIfAbsent(firstChar, TrieNode::new);
        if (word.length() > 1) {
            child.insert(word.substring(1));
        } else {
            child.isWord = true;
        }
    }
}
