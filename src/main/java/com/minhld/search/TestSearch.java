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
        p.addVertex('G');
        p.addVertex('H');
        p.addVertex('I');
        p.addEdge('A', 'B');
        p.addEdge('B', 'F');
        p.addEdge('F', 'H');
        p.addEdge('A', 'C');
        p.addEdge('A', 'D');
        p.addEdge('D', 'G');
        p.addEdge('G', 'I');
        p.addEdge('A', 'E');

        // p.printEdges();
        p.search();
    }

    public static void main(String[] args) {
        new TestSearch().start();
    }
}
