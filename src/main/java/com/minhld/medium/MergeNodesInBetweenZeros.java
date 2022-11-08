package com.minhld.medium;

import com.minhld.objects.ListNode;

public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head, node = head;

        while (curr != null) {
            if (curr.val == 0 && curr.next != null) {
                if (node != curr) {
                    node.next = curr;
                    node = curr;
                }
            } else {
                node.val += curr.val;
                node.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
