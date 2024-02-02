package com.minhld.linkedlist;

public class FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Node c = head, cc;
        Node n;
        while (c != null) {
            if (c.child != null) {
                n = c.next;
                c.next = c.child;
                c.child.prev = c;
                cc = c.child;
                while (cc != null) {
                    if (cc.next != null) {
                        cc = cc.next;
                    } else {
                        cc.next = n;
                        n.prev = cc;
                        break;
                    }
                }
            }
            c = c.next;
        }
        return head;
    }

    public Node flattenChild(Node p) {
        Node c = p.child;
        p.next = c;
        p.child = null;
        c.prev = p;
        Node sc;
        while (c != null) {
            c = c.next;
            if (c.child != null) {
                sc = flattenChild(c);

            }
        }
        return c;
    }
}
