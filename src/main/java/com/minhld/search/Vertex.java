package com.minhld.search;

import lombok.Data;

@Data
public class Vertex {
    char label;
    boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}
