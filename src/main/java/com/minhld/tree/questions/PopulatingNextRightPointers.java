package com.minhld.tree.questions;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        Node c = root, n = null;
        queue.add(c);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                c = queue.poll();
                if (size > 0) c.next = queue.peek();
                if (c.left != null) queue.add(c.left);
                if (c.right != null) queue.add(c.right);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
