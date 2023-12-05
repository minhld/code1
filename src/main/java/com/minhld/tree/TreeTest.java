package com.minhld.tree;

public class TreeTest {
    /* a sample tree
                    63
          27                  80
     13         51        70        92
        26    33    58            82
                  57   60
     */

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
        t.print();
        t.travel(t.root);
    }
}
