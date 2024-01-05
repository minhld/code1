package com.minhld.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Breadth-first Search
 */
public class BFS extends Search {
    public BFS(Vertex[] vertexList, int[][] adjMat) {
        super(vertexList, adjMat);
    }

    @Override
    public void search() {
        Queue<Vertex> queue = new LinkedList<>();
        pushToStack(queue, vertexList[0]);
        Vertex v;
        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int i = 0; i < vertexList.length; i++) {
                if (adjMat[v.getLabel() - 'A'][i] == 1 && !vertexList[i].isWasVisited()) {
                    pushToStack(queue, vertexList[i]);
                }
            }
        }
    }

    private void pushToStack(Queue<Vertex> s, Vertex v) {
        s.add(v);
        v.setWasVisited(true);
        System.out.print(v.getLabel() + " ");
    }
}
