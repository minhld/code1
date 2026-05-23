package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordsDataStructure {
    private final Node root = new Node();

    public static void main(String[] args) {
        AddAndSearchWordsDataStructure dictionary = new AddAndSearchWordsDataStructure();
        dictionary.addWord("ab");
        dictionary.addWord("abcd");

        System.out.println("res = " + dictionary.search(".bc."));
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, key -> new Node());
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node curr) {
        if (curr == null) return false;
        if (index == word.length()) return curr.isWord;

        char c = word.charAt(index);
        if (c != '.') {
            return search(word, index + 1, curr.children.get(c));
        }

        for (Node next : curr.children.values()) {
            if (search(word, index + 1, next)) {
                return true;
            }
        }

        return false;
    }

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }
}
