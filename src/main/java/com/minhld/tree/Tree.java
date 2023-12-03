package com.minhld.tree;

public class Tree {
    Node root;

    public Tree(int val) {
        insert(val);
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node c = root;
        while (val != c.val) {
            if (val < c.val) {
                if (c.left != null) c = c.left;
                else {
                    c.left = new Node(val);
                    return;
                }
            } else {
                if (c.right != null) c = c.right;
                else {
                    c.right = new Node(val);
                    return;
                }
            }
        }
    }

    public Node find(int val) {
        Node c = root;
        if (c.val == val) return c;
        while (c != null) {
            if (val < c.val) c = c.left;
            else c = c.right;
            if (c != null && c.val == val) return c;
        }
        return null;
    }
}
