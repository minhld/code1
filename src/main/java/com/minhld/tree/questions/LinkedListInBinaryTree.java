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
        Integer count = 0;
        ListNode c = head;
        search(map, c, count);
        int total = 0;
        while (head != null) {
            head = head.next;
            total++;
        }
        return count == total;
    }

    void search(Map<Integer, List<TreeNode>> map, ListNode c, Integer count) {
        if (map.containsKey(c.val)) {
            count++;
            if (c.next != null) {
                for (TreeNode n : map.get(c.val)) {
                    if (n.val == c.next.val) {
                        search(map, c.next, count);
                    }
                }
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
