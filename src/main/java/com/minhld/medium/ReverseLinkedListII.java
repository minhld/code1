package com.minhld.medium;

import com.minhld.objects.ListNode;

import java.util.Stack;

public class ReverseLinkedListII extends Thread {
    public void run() {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode head = n1;
        n1.next = n2;
        System.out.println("head = " + reverseBetween(head, 1, 2));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> s = new Stack<>();
        int i = 1;
        ListNode c = head, f = null, l = null;
        while (i < left) {
            f = c;
            c = c.next;
            i++;
        }
        while (i >= left && i <= right) {
            s.push(c);
            c = c.next;
            i++;
        }
        l = s.pop();
        c = l;
        ListNode last = l.next;
        if (f == null) head = l;
        if (f != null) f.next = l;
        while (!s.isEmpty()) {
            c.next = s.pop();
            c = c.next;
        }
        c.next = last;
        return head;
    }

    public static void main(String[] args) {
        new ReverseLinkedListII().start();
    }
}
