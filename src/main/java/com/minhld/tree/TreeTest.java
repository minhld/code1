package com.minhld.tree;

public class TreeTest {
    public static void main(String[] args) {
        Tree t = new Tree(63);
        t.insert(27);
        t.insert(80);
        t.insert(13);
        t.insert(51);
        t.insert(70);
        t.insert(92);
        t.insert(26);
        t.insert(33);
        t.insert(58);
        t.insert(82);
        t.insert(57);
        t.insert(60);
        System.out.println(t.find(51));
        t.travel(t.root);
    }
}
