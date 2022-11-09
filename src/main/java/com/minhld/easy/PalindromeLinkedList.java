package com.minhld.easy;

import com.minhld.objects.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            list.add(curr.val);
            curr = curr.next;
        }
        int listSize = list.size();
        int middle = listSize / 2;
        for (int i = 0; i <= middle; i++) {
            if (list.get(i) != list.get(listSize - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
