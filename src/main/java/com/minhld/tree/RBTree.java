package com.minhld.tree;

/**
 * rules
 *  - is a binary tree
 *  - root is always black
 *  - if parent is red, children must be black
 *  - every path from root to leaf have the same count of black nodes
 */
public class RBTree implements Tree {
    Node root;

    public RBTree(int val) {
        insert(val);
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val, Node.Color.BLACK);
            return;
        }
        Node c = root;
        while (val != c.val) {
            if (val < c.val) {
                if (c.left != null) c = c.left;
                else {
                    c.left = new Node(val, Node.Color.RED);
                    break;
                }
            } else {
                if (c.right != null) c = c.right;
                else {
                    c.right = new Node(val, Node.Color.RED);
                    break;
                }
            }
        }
        fixTree();
    }

    private void fixTree() {
        rotateLeft();
    }

    private void rotateLeft() {
        Node r = root.right, rt = root;
        root = r;
        root.left = rt;
        rt.right = r.left;
    }

    private void rotateRight() {
        Node l = root.left, r = root;
        root = l;
        root.right = r;
        r.left = l.right;
    }

    public void delete(int val) {

    }

    public Node find(int val) {
        return null;
    }

    public void travel(Node n) {

    }

    public void print() {

    }

}
