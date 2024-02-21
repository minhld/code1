package com.minhld.tree.questions;

import com.minhld.objects.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        fetch(root, map);
        while (head != null) {

        }
        return true;
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
