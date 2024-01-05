package com.minhld.search;

import java.util.Stack;

/**
 * Deep-first Search
 */
public class BFS extends Search {
    public BFS(Vertex[] vertexList, int[][] adjMat) {
        super(vertexList, adjMat);
    }

    @Override
    public void search() {
        Stack<Vertex> stack = new Stack<>();
        Vertex v;
        while (!stack.empty()) {
            v = stack.pop();
        }
    }
}
