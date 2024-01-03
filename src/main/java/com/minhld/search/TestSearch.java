package com.minhld.search;

public class TestSearch extends Thread {
    public void run() {
        Graph p = new Graph();
        p.addVertex('A');
        p.addVertex('B');
        p.addVertex('C');
        p.addVertex('D');
        p.addVertex('E');
        p.addVertex('F');

    }

    public static void main(String[] args) {
        new TestSearch().start();
    }
}
