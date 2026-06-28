package com.minhld.linkedlist;

import com.minhld.objects.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList extends Thread {
    public void run() {
        ListNode h = new ListNode(0);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        h = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        reorderList(h);
    }

    public void reorderList(ListNode h) {
        ListNode c = h, s;
        List<ListNode> a = new ArrayList<>();
        int n = 0;
        while (c != null) {
            a.add(c);
            c = c.next;
            n++;
        }
        for (int i = 0; i < n / 2; i++) {
            s = a.get(i).next;
            a.get(i).next = a.get(n - i - 1);
            a.get(n - i - 1).next = s;
        }
        a.get(n / 2).next = null;
    }

    public static void main(String[] args) {
        new ReorderList().start();
    }
}
