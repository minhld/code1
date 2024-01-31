package com.minhld.tree.questions;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        TreeNode c = root;
        traverse(root, list);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                c.left = null;
                c.right = new TreeNode(list.get(i));
                c = c.right;
            }
            root = c;
        }
    }

    private void traverse(TreeNode c, List<Integer> list) {
        if (c == null) return;
        list.add(c.val);
        traverse(c.left, list);
        traverse(c.right, list);
    }
}
