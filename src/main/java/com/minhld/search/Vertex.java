package com.minhld.search;

import lombok.Data;

@Data
public class Vertex {
    char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}
