package com.minhld.tree.questions;

import com.minhld.objects.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListInBinaryTree extends Thread {
    public void run() {
        Integer[] linkedListSamples = { 1,4,2,6,8 };

        ListNode head = Utils.buildLinkedList(linkedListSamples);
        Integer[] samples = { 1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3 };
        TreeNode root = Utils.buildTree(samples);
        System.out.println("res = " + isSubPath(head, root));
    }

    public static void main(String[] args) {
        new LinkedListInBinaryTree().start();
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        fetch(root, map);
        ListNode c = head;
        int count = search(map, c, 0);
        int total = 0;
        while (head != null) {
            head = head.next;
            total++;
        }
        return count == total;
    }

    int search(List<TreeNode> list, ListNode c) {
        if (c == null) return 0;
        TreeNode n;
        for (int i = 0; i < list.size(); i++) {
            n = list.get(i);
            if (n.val == c.val) {
                search(list, c.next);
            }
        }
    }

    void fetch(TreeNode c, Map<Integer, List<TreeNode>> p) {
        if (c == null) return;
        if (c.left != null) {
            fetch(c.left, p);
        }
        p.computeIfAbsent(c.val, k -> new ArrayList<>()).add(c);
        if (c.right != null) {
            fetch(c.right, p);
        }
    }
}
