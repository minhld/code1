package com.minhld.search;

import com.minhld.easy.Stream;

import java.util.Arrays;

public class Graph {
    public final int MAX_VERTS = 20;
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int nVerts;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(char A, char B) {
        adjMat[A - 'A'][B - 'A'] = 1;
        adjMat[B - 'A'][A - 'A'] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void printEdges() {
        Arrays.stream(adjMat)
                .peek(a -> Arrays.stream(a).forEach(e -> System.out.print(" " + e)))
                .forEach(l -> System.out.println());
    }

    public void search() {
        Search searcher = new DFS(vertexList, adjMat);
        searcher.search();
    }
}
