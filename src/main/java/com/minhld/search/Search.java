package com.minhld.search;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Search {
    Vertex[] vertexList;
    int[][] adjMat;

    abstract void search();
}
