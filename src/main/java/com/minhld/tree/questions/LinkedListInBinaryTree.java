package com.minhld.tree.questions;

import com.minhld.objects.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListInBinaryTree extends Thread {
    public void run() {

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
        if (c == null) return;
        List<TreeNode> list;
        if (map.containsKey(c.val)) {
            count++;
            for (TreeNode n : map.get(c.val)) {
                search(map, c.next, count);
            }
        }
    }

    void fetch(TreeNode c, Map<Integer, List<TreeNode>> p) {
        if (c == null) return;
        if (c.left != null) {
            p.computeIfAbsent(c.val, k -> new ArrayList<>()).add(c.left);
        }
        p.computeIfAbsent(c.val, k -> new ArrayList<>()).add(c);
        if (c.right != null) {
            p.computeIfAbsent(c.val, k -> new ArrayList<>()).add(c.right);
        }
    }
}
