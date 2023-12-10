package com.minhld.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class BinaryTree implements Tree {

    Node root;

    public BinaryTree(int val) {
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

    public void delete(int val) {
        Node c = root, p = null;
        boolean isLeft = false;
        while (c != null && c.val != val) {
            p = c;
            isLeft = val < c.val;
            if (val < c.val) c = c.left;
            else c = c.right;
        }
        if (c == null || p == null) return;
        else if (c.right == null) {
            if (isLeft) p.left = c.left;
            else p.right = c.left;
        } else {
            Node r = c;
            p = c;
            c = c.right;
            isLeft = false;
            while (c.left != null) {
                r = c;
                c = c.left;
                isLeft = true;
            }
            if (isLeft) r.left = c.right;
            else r.right = c.right;
            p.val = c.val;
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

    public void travel(Node n) {
        if (n == null) return;
        travel(n.left);
        System.out.print(n.val + " ");
        travel(n.right);
    }

    public void print() {
        Queue<Node> q = new LinkedList<>();
        Node c = root;
        q.add(c);
        int qSize;
        while (!q.isEmpty()) {
            qSize = q.size();
            while (--qSize >= 0) {
                c = q.poll();
                System.out.print(c.val + " ");
                if (c.left != null) q.add(c.left);
                if (c.right != null) q.add(c.right);
            }
            System.out.println();
        }
    }
}
