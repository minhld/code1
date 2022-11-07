package com.minhld.medium;

import java.util.*;

public class LinkedListComponents extends Thread {
    public void run() {

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> itemSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            itemSet.add(nums[i]);
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            if (itemSet.contains(curr.val)) {
                count++;
                while (curr != null && itemSet.contains(curr.val)) {
                    itemSet.remove(curr.val);
                    curr = curr.next;
                }
            }
            if (curr != null) {
                curr = curr.next;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        new LinkedListComponents().start();
    }
}
