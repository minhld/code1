package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordsDataStructure extends Thread {
    public void run() {
        tree = new Tree();
        addWord("a");
        addWord("ab");

        System.out.println("res = " + search("ab"));
    }

    /*
    b
    |\ \
    a c .
    |  \ \
    d   e d e
     */

    public static void main(String[] args) {
        new AddAndSearchWordsDataStructure().start();
    }
    Tree tree;

    public void addWord(String word) {
        TreeNode p = tree.root;
        Map<Character, TreeNode> currMap = p.links;
        int newLength = 0;
        for (char c : word.toCharArray()) {
            TreeNode cn = currMap.computeIfAbsent(c, TreeNode::new);
            tree.addNode(p, cn);
            p = cn;
            newLength++;
        }
        tree.length = Math.max(newLength, tree.length);
    }

    public boolean search(String word) {
        if (word.length() > tree.length) return false;
        TreeNode curr = tree.root;
        for (char c : word.toCharArray()) {
            curr = c != '.' ? curr.links.get(c) : tree.dot;
            if (curr == null) return false;
        }
        return true;
    }

    static class Tree {
        TreeNode root = new TreeNode();
        TreeNode dot = new TreeNode('.');
        int length = 0;

        public void addNode(TreeNode p, TreeNode c) {
            p.links.putIfAbsent(c.val, c);
            p.links.putIfAbsent(dot.val, dot);
            dot.links.putIfAbsent(c.val, c);
        }
    }

    static class TreeNode {
        Character val;
        Map<Character, TreeNode> links;

        public TreeNode() {
            this.val = null;
            this.links = new HashMap<>();
        }

        public TreeNode(Character val) {
            this.val = val;
            this.links = new HashMap<>();
        }
    }
}
