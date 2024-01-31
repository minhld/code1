package com.minhld.tree.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTest extends Thread {
    public void run() {
        Integer[] samples = { 1, 2, 5, 3, 4, null, 6 };
        TreeNode root = buildTree(samples);
        System.out.println(root);
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
                    if (idx < input.length) {
                        c.left = input[idx++] != null ? new TreeNode(input[idx++]) : null;
                        queue.add(c.left);
                    }
                    if (idx < input.length) {
                        c.right = input[idx++] != null ? new TreeNode(input[idx++]);
                        queue.add(c.right);
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
