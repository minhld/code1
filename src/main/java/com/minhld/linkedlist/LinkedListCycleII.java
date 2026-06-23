package com.minhld.linkedlist;

import com.minhld.objects.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII extends Thread {
    public void run() {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode c = head;
        Set<ListNode> s = new HashSet<>();
        while (c != null) {
            if (s.contains(c)) return c;
            else s.add(c);
            c = c.next;
        }
        return null;
    }

    public static void main(String[] args) {
        new LinkedListCycleII().start();
    }
}
