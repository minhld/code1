package com.minhld.search;

import java.util.Stack;

/**
 * Deep-First Search
 */
public class DFS extends Search {
    public DFS(Vertex[] vertexList, int[][] adjMat) {
        super(vertexList, adjMat);
    }

    @Override
    public void search() {
        Stack<Vertex> stack = new Stack<>();
        pushToStack(stack, vertexList[0]);
        Vertex v;
        boolean foundNext;
        while (!stack.empty()) {
            v = stack.peek();
            foundNext = false;
            for (int i = 0; i < vertexList.length; i++) {
                if (adjMat[v.getLabel() - 'A'][i] == 1 && !vertexList[i].isWasVisited()) {
                    pushToStack(stack, vertexList[i]);
                    foundNext = true;
                    break;
                }
            }
            if (!foundNext) {
                stack.pop();
            }
        }
    }

    private void pushToStack(Stack<Vertex> s, Vertex v) {
        s.push(v);
        v.setWasVisited(true);
        System.out.print(v.getLabel() + " ");
    }
}
