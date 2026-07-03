package com.minhld.easy;

import com.minhld.objects.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedList extends Thread {
    public void run() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("res = " + reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> s = new Stack<>();
        ListNode c = head;
        while (c != null) {
            s.push(c);
            c = c.next;
        }
        head = s.pop();
        c = head;
        while (!s.isEmpty()) {
            c.next = s.pop();
            c = c.next;
        }
        c.next = null;
        return head;
    }

    public static void main(String[] args) {
        new ReverseLinkedList().start();
    }
}
