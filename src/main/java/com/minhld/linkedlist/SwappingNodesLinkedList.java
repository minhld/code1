package com.minhld.linkedlist;

import com.minhld.objects.ListNode;

public class SwappingNodesLinkedList extends Thread {
    public void run() {

    }

    public ListNode swapNodes(ListNode h, int k) {
        ListNode c1 = h, c2 = h, f1 = new ListNode(-1, c1), f2 = new ListNode(-1, c2);
        int i = 1;
        // get the first node
        while (c1 != null && i < k) {
            f1 = c1;
            c1 = c1.next;
            i++;
        }
        ListNode l1 = c1;
        // get the second node
        while (l1.next != null) {
            l1 = l1.next;
            f2 = c2;
            c2 = c2.next;
        }
        if (f1.val == -1) h = c2;
        if (f2.val == -1) h = c1;
        ListNode p1 = f1.next;
        f1.next = f2.next;
        f2.next = p1;
        ListNode p2 = c2.next;
        c2.next = c1.next;
        c1.next = p2;
        return h;
    }

    public static void main(String[] args) {
        new SwappingNodesLinkedList().start();
    }
}
