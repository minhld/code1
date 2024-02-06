package com.minhld.linkedlist;

public class FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Node c = head;
        Node n;
        while (c != null) {
            if (c.child != null) {
                flattenChild(c);
            }
            c = c.next;
        }
        return head;
    }

    void flattenChild(Node p) {
        Node n = p.next;
        p.next = p.child;
        Node c = p.child;
        p.child = null;
        c.prev = p;
        while (c != null) {
            if (c.child != null) {
                flattenChild(c);
            }
            if (c.next != null) {
                c = c.next;
            } else {
                c.next = n;
                if (n != null) n.prev = c;
                c = null;
            }
        }
    }
}
