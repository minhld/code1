package com.minhld.tree.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTest extends Thread {
    public void run() {
        Integer[] samples = { 1, 2, 5, 3, 4, null, 6 };
        TreeNode root = buildTree(samples);
        System.out.println(root);
        TreeNode list = new TreeNode(root.val);
        TreeNode head = list;
        traverse(root, list);
        traverse(head);
    }

    private void traverse(TreeNode c) {
        if (c == null) return;
        System.out.print(c.val + " ");
        traverse(c.left);
        traverse(c.right);
    }

    private void traverse(TreeNode c, TreeNode list) {
        if (c == null) return;
        list.val = c.val;
        list.right = new TreeNode();
        System.out.print(list.val);
        traverse(c.left, list.right);
        traverse(c.right, list.right);
    }

    TreeNode buildTree(Integer[] input) {
        if (input.length == 0) return null;
        TreeNode root = new TreeNode(input[0]);

        if (input.length > 1) {
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode c;
            queue.add(root);
            int idx = 1, size;
            while (!queue.isEmpty()) {
                size = queue.size();
                while (size-- > 0) {
                    c = queue.poll();
                    if (c != null && idx < input.length) {
                        if (input[idx] != null) {
                            c.left = new TreeNode(input[idx++]);
                            queue.add(c.left);
                        } else {
                            c.left = null;
                            idx++;
                        }
                    }
                    if (c != null && idx < input.length) {
                        if (input[idx] != null) {
                            c.right = new TreeNode(input[idx++]);
                            queue.add(c.right);
                        } else {
                            c.right = null;
                            idx++;
                        }
                    }
                    if (idx >= input.length) return root;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        new TreeTest().start();
    }
}
