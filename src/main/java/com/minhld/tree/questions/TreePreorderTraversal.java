package com.minhld.tree.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node c = s.pop();
            l.add(c.val);
            for (int i = c.children.size() - 1; i >= 0; i--) {
                s.push(c.children.get(i));
            }
        }
        return l;
    }
}
