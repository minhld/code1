package com.minhld.tree;

public class TreeTest extends Thread {

    public void run() {
        createRegTree();
    }

    private void createRbTree() {

    }

    /* a sample tree
                    63
          27                  80
     13          51        70        92
        18    33     61         82
      15   20       57     62
    14   17    54       58
                55       60
    */
    private void createRegTree() {
        BinaryTree t = new BinaryTree(63);
        t.insert(27);
        t.insert(80);
        t.insert(13);
        t.insert(51);
        t.insert(70);
        t.insert(92);
        t.insert(18);
        t.insert(33);
        t.insert(61);
        t.insert(82);
        t.insert(15);
        t.insert(20);
        t.insert(57);
        t.insert(62);
        t.insert(14);
        t.insert(17);
        t.insert(54);
        t.insert(58);
        t.insert(55);
        t.insert(60);
        // System.out.println(t.find(51));
        t.print();
        t.delete(15);
        t.print();
        // t.delete(58);
        // t.travel(t.root);
    }

    public static void main(String[] args) {
        new TreeTest().start();
    }
}
