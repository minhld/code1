package com.minhld.medium;

import com.minhld.objects.ListNode;

public class RemoveDuplicateNodes {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head, prev = null;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
                if (prev == null) {
                    head = curr;
                } else {
                    prev.next = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
