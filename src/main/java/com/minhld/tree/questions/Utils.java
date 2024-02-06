package com.minhld.tree.questions;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {
    public static TreeNode buildTree(Integer[] input) {
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
}
