package com.minhld.medium;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordsDataStructure extends Thread {
    public AddAndSearchWordsDataStructure() {
        tree = new Tree();
    }

    public void run() {
//        addWord("bad");
//        addWord("dad");
//        addWord("mad");
        addWord("ab");
        addWord("abcd");

        System.out.println("res = " + search("a."));
    }

    public static void main(String[] args) {
        new AddAndSearchWordsDataStructure().start();
    }
    Tree tree;

    public void addWord(String word) {
        TreeNode p = tree.root;
        TreeNode pd = null;
        Map<Character, TreeNode> currMap = p.links;
        for (int i = 0; i < word.length(); i++) {
            TreeNode cn = currMap.computeIfAbsent(word.charAt(i), TreeNode::new);
            tree.addNode(p, cn, pd);
            pd = p.links.get('.');
            p = cn;
            currMap = p.links;
            if (i == word.length() - 1) {
                p.word = word;
                pd.word = word;
            }
        }
    }

    public boolean search(String word) {
        TreeNode curr = tree.root;
        for (char c : word.toCharArray()) {
            curr = curr.links.get(c);
            if (curr == null) return false;
        }
        return curr.word != null;
    }

    static class Tree {
        TreeNode root = new TreeNode();

        public void addNode(TreeNode p, TreeNode c, TreeNode pd) {
            p.links.putIfAbsent(c.val, c);
            p.links.putIfAbsent('.', new TreeNode('.'));
            if (pd != null) {
                pd.links.putAll(p.links);
            }
        }
    }

    static class TreeNode {
        Character val;
        Map<Character, TreeNode> links;
        String word;

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
