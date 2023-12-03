package com.minhld.tree;

import lombok.Data;

@Data
public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[val=" + val + ",l=" + left + ",right=" + right + "]";
    }
}
