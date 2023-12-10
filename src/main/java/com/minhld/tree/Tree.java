package com.minhld.tree;

public interface Tree {
    void insert(int val);
    void delete(int val);
    Node find(int val);
    void travel(Node n);
    void print();
}