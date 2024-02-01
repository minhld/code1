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
}
