package com.minhld.tree;

import lombok.Data;

@Data
public class Node {
    public enum Color { RED, BLACK };

    int val;
    Node left;
    Node right;
    Color color;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Color color) {
        this.val = val;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[val=" + val + ",l=" + left + ",right=" + right + "]";
    }
}
